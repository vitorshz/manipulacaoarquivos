package br.unipar.manipulacao.arquivos;

import br.unipar.manipulacao.arquivos.model.Pessoa;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ImportarArquivos {
    
    private static String arquivo = "C:\\Users\\lucia\\Downloads\\pessoa.csv";
    
    public static void main(String[] args) {
   
        try {
            BufferedReader br = new BufferedReader(new FileReader (arquivo));
            String linha;
            Integer id = 0;
            List<Pessoa> pessoaList = new ArrayList<>();
            
            br.readLine();
            while((linha = br.readLine()) != null){
                String[] campos = linha.split(";");
                
                Pessoa pessoa = new Pessoa();

                pessoa.setId(id++);
                pessoa.setNome(campos[0]);
                pessoa.setIdade(Integer.parseInt(campos[1]));
                pessoa.setCpf(campos[2]);
                pessoa.setRg(campos[3]);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate date = LocalDate.parse(campos[4], formatter);
                pessoa.setData_nasc(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
                
                pessoa.setSexo(campos[5]);
                pessoa.setSigno(campos[6]);
                pessoa.setMae(campos[7]);
                pessoa.setPai(campos[8]);
                pessoa.setEmail(campos[9]);
                pessoa.setSenha(campos[10]);
                pessoa.setCep(campos[11]);
                pessoa.setEndereco(campos[12]);
                pessoa.setNumero(campos[13]);
                pessoa.setBairro(campos[14]);
                pessoa.setCidade(campos[15]);
                pessoa.setEstado(campos[16]);
                pessoa.setTelefone_fixo(campos[17]);
                pessoa.setCelular(campos[18]);
                pessoa.setAltura(Double.valueOf(campos[19]));
                pessoa.setPeso(Double.valueOf(campos[20]));
                pessoa.setTipo_sanguineo(campos[21]);
                pessoa.setCor(campos[22]);
                
                pessoaList.add(pessoa);
            }
            for (Pessoa pessoa : pessoaList) {
                System.out.println(pessoa.toString());
            }
        } catch (IOException e) {
            System.out.println("Algo deu errado...."+e.getMessage());
        }
        
        
        
    }
}
