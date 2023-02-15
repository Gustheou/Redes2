javac --module-path /home/gustavo/Documents/Programacao_Projetos/JavaLibs/javafx-sdk-19.0.2.1/lib --add-modules javafx.controls,javafx.fxml Principal.java;
echo "Arquivos compilados!";
java --module-path /home/gustavo/Documents/Programacao_Projetos/JavaLibs/javafx-sdk-19.0.2.1/lib --add-modules javafx.controls,javafx.fxml Principal;
echo "Removendo:" *.class;
rm *.class
echo "Arquivos removidos!";
