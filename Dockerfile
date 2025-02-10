# Usa a imagem oficial do Tomcat
FROM tomcat:latest

# Define o diretório de trabalho dentro do contêiner
WORKDIR /usr/local/tomcat/webapps/

# Copia a aplicação .war para o diretório webapps do Tomcat
COPY build/libs/bloodbank*.war /usr/local/tomcat/webapps/bloodbank.war


# Expõe a porta padrão do Tomcat
EXPOSE 8080

# Inicia o Tomcat
CMD ["catalina.sh", "run"]
