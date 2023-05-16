package dio.collection.list;

/*Dada as seguintes informações sobre os gatos, crie uma lista e ordene esta lista exibindo:
* (nome - idade - cor);
*
* Gato 1 = nome: Jon, idade: 18, cor: preto
* Gato 2 = nome: Simba, idade: 6, cor: tigrado
* Gato 3 = nome: Jon, idade: 12, cor: amarelo
* */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploOrdenacaoList {
    public static void main(String[] args){

        /*Segundamente, precisamos criar a lista*/
        List<Gato> meusGatos = new ArrayList<>(){{
            add(new Gato("Jon", 18, "preto"));
            add(new Gato("Simba", 6, "tigrado"));
            add(new Gato("Jon", 12, "amarelo"));
        }};

        System.out.println("---\tOrdem de inserção\t---");
        System.out.println(meusGatos);

        System.out.println("---\tOrdem aleatória\t---");
        Collections.shuffle(meusGatos);//'.shuffle' para misturar as posições
        System.out.println(meusGatos);

        System.out.println("---\tOrdem natural (Nome)\t---");//para fazer isso eu preciso implementar a interface 'Comparable'. Que por sua vez precisa sobrescrever com o método 'compareTo'
        Collections.sort(meusGatos);//
        System.out.println(meusGatos);

        System.out.println("---\tOrdem Idade\t---");
        //Collections.sort(meusGatos,new ComparatorIdade());//ordena por idade
        meusGatos.sort(new ComparatorIdade());//também funciona para ordenar por idade
        System.out.println(meusGatos);

        System.out.println("---\tOrdem cor\t---");
        //Collections.sort(meusGatos, new ComparatorCor());
        meusGatos.sort(new ComparatorCor());
        System.out.println(meusGatos);

        System.out.println("---\tOrdem nome/cor/idade\t---");
        //Collections.sort(meusGatos, new ComparatorCorNomeIdade());
        meusGatos.sort(new ComparatorCorNomeIdade());
        System.out.println(meusGatos);




    }
}

/*Primeiramente, precisamos criar a classe*/
class Gato implements Comparable<Gato>{ //interface Comparable
    private String nome;
    private Integer idade;
    private String cor;

    /*alt+insert --> Constructor ou também: aba 'Code' --> generate --> Constructor*/

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    /*alt+insert --> Getter ou também: aba Code --> Generate --> Getter*/
    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;

    }

    /*Para sobrescrever e não sair o endereço de memório eu preciso usar o toString()
    * alt+insert --> Generate --> toString() */

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override //sobrescreveu o método 'Comparable' da linha 43 para nao dar erro.
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}


class ComparatorIdade implements Comparator<Gato>{ //com o comparator nós somos obrigado a sobrescrever o método Compare

    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

class ComparatorCor implements Comparator<Gato>{

    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}

class ComparatorCorNomeIdade implements Comparator<Gato>{

    @Override
    public int compare(Gato g1, Gato g2) {
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome != 0) return nome;

        int cor = g1.getCor().compareTo(g2.getCor());
        if (cor != 0) return cor;

        return Integer.compare(g1.getIdade(), g2.getIdade());

    }
}