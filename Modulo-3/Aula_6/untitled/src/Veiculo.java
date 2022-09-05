// Streams

import java.util.ArrayList;
 import java.util.List;
import java.util.stream.Stream;

public class Veiculo {
     String id;
     String tipo;
     int quantidadeDeAssentos;
     int quantidadeDeRodas;

     public int getQuantidadeDeAssentos() {
         return quantidadeDeAssentos;
     }

     public void setId(String id) {
         this.id = id;
     }

     public void setQuantidadeDeAssentos(int quantidadeDeAssentos) {
         this.quantidadeDeAssentos = quantidadeDeAssentos;
     }

     public int getQuantidadeDeRodas() {
         return quantidadeDeRodas;
     }

     public void setQuantidadeDeRodas(int quantidadeDeRodas) {
         this.quantidadeDeRodas = quantidadeDeRodas;
     }

     public String getId() {
         return id;
     }

     public void setTipo(String tipo) {
         this.tipo = tipo;
     }

     public String getTipo() {
         return tipo;
     }

     public Veiculo(){}
     public Veiculo (String id, String tipo, int quantidadeDeAssentos, int quantidadeDeRodas){
         this.id = id;
         this.tipo = tipo;
         this.quantidadeDeAssentos = quantidadeDeAssentos;
         this.quantidadeDeRodas = quantidadeDeRodas;
     }
     public List<Veiculo> popular() {
         List<Veiculo> lista = new ArrayList<Veiculo>();
         Veiculo veiculo1 = new Veiculo("v1", "Carro", 4, 4);
         lista.add(veiculo1);
         Veiculo veiculo2 = new Veiculo("v2", "Moto", 2, 2);
         lista.add(veiculo2);
         Veiculo veiculo3 = new Veiculo("v3", "Avião", 100, 3);
         lista.add(veiculo3);
         Veiculo veiculo4 = new Veiculo("v4", "Bicicleta", 1, 2);
         lista.add(veiculo4);
         return lista;
     }
      @Override
      public String toString() {
          return this.tipo;
      }

     public static void main(String[] args) {
         List<Veiculo> veiculos = new Veiculo().popular();
         Stream<Integer> streamFilter = veiculos.stream().filter(veiculo -> veiculo.getQuantidadeDeAssentos() > 2).map(Veiculo::getQuantidadeDeRodas);
         Stream<Veiculo> streamMap = veiculos.stream().filter(veiculo -> veiculo.getQuantidadeDeAssentos() > 2);
         Stream<Veiculo> streamSorted = veiculos.stream().filter(veiculo -> veiculo.getQuantidadeDeAssentos() > 2).sorted(Comparator.comparing(Veiculo::getTipo));
         Stream<Veiculo> streamDistinct = veiculos.stream().distinct();

     }
  }