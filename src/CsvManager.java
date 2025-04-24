import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvManager {

    public static void writeBicicletasToCsv(List<Bicicleta> bicicletas, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("id,tipo,tamanho,marca,modelo,taxaDiaria,deposito,status\n");
            for (Bicicleta b : bicicletas) {
                writer.write(b.toCsvLine() + "\n");
            }
        }
    }

    public static List<Bicicleta> readBicicletasFromCsv(String fileName) throws IOException {
        List<Bicicleta> bicicletas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine(); // Ignora o cabeçalho
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Bicicleta b = new Bicicleta(data[0], data[1], data[2], data[3], data[4],
                        data[5], data[6], data[7]);
                bicicletas.add(b);
            }
        }
        return bicicletas;
    }

    public static void writeAlunosToCsv(List<Aluno> alunos, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("matricula,nome,endereco,telefone,email\n");
            for (Aluno a : alunos) {
                writer.write(a.toCsvLine() + "\n");
            }
        }
    }

   public static List<Aluno> readAlunosFromCsv(String fileName) throws IOException {
        List<Aluno> alunos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine(); // Ignora o cabeçalho
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Aluno a = new Aluno(data[0], data[1], data[2], data[3], data[4]);
                alunos.add(a);
            }
        }
        return alunos;
    }

    public static void main(String[] args) throws IOException {
        List<Bicicleta> bicicletas = new ArrayList<>();
        bicicletas.add(new Bicicleta(
                "B001", "Mountain", "M",
                "Caloi", "Elite", "50.00",
                "100.00", "disponivel"
        ));
        bicicletas.add(new Bicicleta(
                "B002", "Road", "G",
                "Trek", "Domane", "60.00",
                "120.00", "alugado"
        ));
        writeBicicletasToCsv(bicicletas, "bicicletas.csv");
        List<Bicicleta> loadedBicicletas = readBicicletasFromCsv("bicicletas.csv");
        System.out.println("Bicicletas carregadas: " + loadedBicicletas.size());

        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno(
                "2023001", "João Silva", "Rua A, 123",
                "11987654321", "joao@email.com"
        ));
        alunos.add(new Aluno(
                "2023002", "Maria Souza", "Rua B, 456",
                "11912345678", "maria@email.com"
        ));
        writeAlunosToCsv(alunos, "alunos.csv");
        List<Aluno> loadedAlunos = readAlunosFromCsv("alunos.csv");
        System.out.println("Alunos carregados: " + loadedAlunos.size());
    }
}