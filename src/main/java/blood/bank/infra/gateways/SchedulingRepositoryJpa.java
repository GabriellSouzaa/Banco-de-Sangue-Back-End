package blood.bank.infra.gateways;

import blood.bank.application.gateways.SchedulingRepositoryGateway;
import blood.bank.domain.entities.scheduling.Scheduling;
import blood.bank.infra.mappers.SchedulingEntityMapper;
import blood.bank.infra.models.requests.SchedulingRequest;
import blood.bank.infra.persistence.models.DonorEntity;
import blood.bank.infra.persistence.models.SchedulingEntity;
import blood.bank.infra.persistence.repositories.DonorRepository;
import blood.bank.infra.persistence.repositories.SchedulingRepository;
import blood.bank.infra.utils.reports.JasperReportUtils;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class SchedulingRepositoryJpa implements SchedulingRepositoryGateway {

    private final SchedulingRepository schedulingRepository;

    private final DonorRepository donorRepository;

    public SchedulingRepositoryJpa(SchedulingRepository schedulingRepository, SchedulingEntityMapper schedulingEntityMapper, DonorRepository donorRepository) {
        this.schedulingRepository = schedulingRepository;
        this.donorRepository = donorRepository;
    }


    @Override
    public List<Scheduling> getSchedulings() {
        List<SchedulingEntity> schedulings = this.schedulingRepository.findAll();
        return schedulings.stream().map(SchedulingEntityMapper::toScheduling).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<byte[]> generateReportSchedulingMonth() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("reports/scheduling.jrxml")).getFile());

        List<Scheduling> schedulings = this.getSchedulings();
        List<Scheduling> schedulingMonth = schedulings.stream()
                .filter(s -> s.getDateTimeSchedule().getMonth() == LocalDate.now().getMonth() &&
                        s.getDateTimeSchedule().getYear() == LocalDate.now().getYear())
                .sorted((s1, s2) -> s1.getDateTimeSchedule().compareTo(s2.getDateTimeSchedule()))
                .toList();


        LocalDateTime dataEmissao = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String dataEmissaoFormatada = dataEmissao.format(formatter);

        JRBeanCollectionDataSource schedulingsMonths = new JRBeanCollectionDataSource(schedulingMonth);
        Map<String, Object> parametros = new HashMap<>();

        parametros.put("schedulings", schedulingsMonths);
        parametros.put("dataEmissaoFormatada", dataEmissaoFormatada);
        byte[] bytes = JasperReportUtils.geraRelatorioEmPDF(file.getAbsolutePath(), parametros);

        return JasperReportUtils.retornaResponseEntityRelatorio(bytes);
    }

    @Override
    public ResponseEntity<byte[]> generateReportSchedulingCanceled() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("reports/schedulingCanceled.jrxml")).getFile());

        List<Scheduling> schedulings = this.getSchedulings();

        List<Scheduling> schedulingCanceled =  schedulings.stream()
                .filter(Scheduling::isCanceled)
                .collect(Collectors.toList());

        LocalDateTime dataEmissao = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String dataEmissaoFormatada = dataEmissao.format(formatter);

        JRBeanCollectionDataSource schedulingsCanceled = new JRBeanCollectionDataSource(schedulingCanceled);
        Map<String, Object> parametros = new HashMap<>();

        parametros.put("schedulings", schedulingsCanceled);
        parametros.put("dataEmissaoFormatada", dataEmissaoFormatada);
        byte[] bytes = JasperReportUtils.geraRelatorioEmPDF(file.getAbsolutePath(), parametros);

        return JasperReportUtils.retornaResponseEntityRelatorio(bytes);
    }

    @Override
    public void createScheduling(Long idDonor, SchedulingRequest schedulingRequest) {
        SchedulingEntity schedulingEntity = new SchedulingEntity();
        DonorEntity donor = donorRepository.findById(idDonor).orElseThrow(() -> new RuntimeException("Não existe Doador com esse id!"));
        schedulingEntity.setDonor(donor);
        schedulingEntity.setDateTimeSchedule(schedulingRequest.getDateTimeSchedule());
        schedulingEntity.setStatus(schedulingRequest.getStatus());
        schedulingEntity.setObservations(schedulingRequest.getObservations());
        schedulingEntity.setCanceled(schedulingRequest.isCanceled());
        this.schedulingRepository.save(schedulingEntity);

    }

    @Override
    public void updateScheduling(Long id, SchedulingRequest schedulingRequest) {
        SchedulingEntity schedulingEntity = this.schedulingRepository.findById(id).orElseThrow(() -> new RuntimeException("Não existe agendamento com esse id!"));
        schedulingEntity.setDonor(schedulingEntity.getDonor());
        schedulingEntity.setDateTimeSchedule(schedulingRequest.getDateTimeSchedule());
        schedulingEntity.setStatus(schedulingRequest.getStatus());
        schedulingEntity.setObservations(schedulingRequest.getObservations());
        schedulingEntity.setCanceled(schedulingRequest.isCanceled());
        this.schedulingRepository.save(schedulingEntity);
    }

    @Override
    public void deleteById(Long id) {
        SchedulingEntity schedulingEntity = this.schedulingRepository.findById(id).orElseThrow(() -> new RuntimeException("Não existe agendamento com esse id!"));
        this.schedulingRepository.delete(schedulingEntity);
    }

    @Override
    public List<Scheduling> getSchedulingsByDonor(Long idDonor) {
        DonorEntity donor = donorRepository.findById(idDonor).orElseThrow(() -> new RuntimeException("Não existe Doador com esse id!"));
        List<SchedulingEntity> schedulings = this.schedulingRepository.findAllByDonorId(donor.getId());
        return schedulings.stream().map(SchedulingEntityMapper::toScheduling).collect(Collectors.toList());
    }
}
