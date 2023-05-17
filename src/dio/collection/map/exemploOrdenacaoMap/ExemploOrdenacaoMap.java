package dio.collection.map.exemploOrdenacaoMap;

/*Dadas as seguintes informações sobre os meus livros e seus autores,
crie um dicionário e ordene este dicionário, com a seguinte esquema:
(Nome Autor -  Nome Livro)

Autor: Hawking, Stephen - Livro: Uma breve história do tempo - páginas: 256
Autor: Duhigg, Charles - Livro: O poder do hábito - páginas: 408
Autor: Harari, Yuval Noah - Livro: 21 lições para o século 21 - páginas: 432
* */

import java.util.*;

import static javax.swing.UIManager.put;

public class ExemploOrdenacaoMap {
    public static void main(String[] args) {

        System.out.println("---\tOrdem Aletória\t--- ");//1)Criar a classe de livros. 2)Colocar os atributos nome e páginas.
        /*Ordem aleatória é o HashMap*/
        Map<String, Livro> meusLivros = new HashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma breve história do tempo", 256));
            put("Duhigg, Charles", new Livro("O poder do hábito", 408));
            put("Harari, Yuval Noah", new Livro("21 lições para o século 21", 432));
                    }};
        for (Map.Entry<String, Livro> livro :meusLivros.entrySet()) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println("---\tOrdem de inserção\t---");//Neste é LinkedHashMap
        Map<String, Livro> meusLivros1 = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma breve história do tempo", 256));
            put("Duhigg, Charles", new Livro("O poder do hábito", 408));
            put("Harari, Yuval Noah", new Livro("21 lições para o século 21", 432));
        }};
        for (Map.Entry<String, Livro> livro :meusLivros1.entrySet()) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println("---\tOrdem Alfabética dos autores\t---");// É necessário imprimir de acordo com as chaves. E usar a implementação TreeMap.
        Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros1);
        for (Map.Entry<String, Livro> livro :meusLivros2.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("---\tOrdem alfabética dos títulos dos livros:");//Os títulos são valores, portanto precisamos usar um TreeSet. Usar um comparator.
        Set<Map.Entry<String, Livro>>  meusLivros3 = new TreeSet<>(new ComparatorNome());//depois de criado, criar um comparator.
        meusLivros3.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro :meusLivros3)
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        /*Para fazer */
        System.out.println("---\tOrdem número de páginas\t---");








    }
}

class   Livro{
    private String nome;
    private Integer paginas;

    /* 3)GENERATE CONSTRUCTORS */
    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    /* 4) GENERATE GETTERS*/

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    /* 5) GENERATE EQUALS() AND HASHCODE()*/ // porque vou usar o TreeMap, HashMap e LinkedHashMap

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(nome, livro.nome) && Objects.equals(paginas, livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    /* 6) GENERATE TOSTRING() */ //Porque queremos que apareça a string no lugar do endereço de memória como resposta

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}