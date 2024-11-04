package blood.bank.infra.gateways;

import blood.bank.application.gateways.SchedulingRepositoryGateway;
import blood.bank.domain.entities.donor.Donor;
import blood.bank.domain.entities.scheduling.Scheduling;
import blood.bank.infra.mappers.SchedulingEntityMapper;
import blood.bank.infra.persistence.models.SchedulingEntity;
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

    public SchedulingRepositoryJpa(SchedulingRepository schedulingRepository, SchedulingEntityMapper schedulingEntityMapper) {
        this.schedulingRepository = schedulingRepository;
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
}
