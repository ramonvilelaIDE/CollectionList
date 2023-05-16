package dio.collection.set;

import java.util.*;

public class ExeploSet {
    public static void main(String[] args) {

        // Dada uma lista com 7 notas de um aluno[7, 8.5, 9.3, 5, 7, 0, 3.6], faça:

        /* Formas de iniciar uma lista usando a interface Set */
        // Set notas = new HashSet(); // Antes do java 5
        // Set<Double> notas = new HashSet<>(); //Generics (jdk 5) - Diamond Operator (jdk 7)
        // HashSet<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        /* Set<Double> notas  = Set.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
            notas.add(1d);
            notas.remove(5d);
            System.out.println(notas);
         */

        System.out.println("Crie um conjunto e adicione as notass: ");
        HashSet<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas.toString()); // ou também pode usar como argumento apenas '(notas)'

        //System.out.println("Exiba a posição da nota 5.0");//Por conta de usarmos o Set (principalmente HashSet), não podemos buscar a posição com o método 'indexOf()'. Portanto,"vamos pular".

        /*System.out.println("Adicione na lista a nota 8.0 na posição 4: "); //Mesmo sentido, eu nao consigo trabalhar composição dentro de um Set */

        /*System.out.println("Substitua a nota 5.0 pela nota 6.0: ");//Aqui também não é possível por ser um Set.*/

        System.out.println("Confira se a nota 5.0 está no conjunto: " + notas.contains(5d));//passamos o objeto como parâmetro. Retorna um boolean.

/*//        System.out.println("Exiba a terceira nota adicionada: ");*/

        System.out.println("Exiba a menor nota: " + Collections.min(notas));//Análogo ao List

        System.out.println("Exiba a maior nota: " + Collections.max(notas));

//        System.out.println("Exiba a soma dos valores: ");//Devemos usar o Iterator para fazer a soma do conjunto
        /*LOOP para somar os elementos dentro do set. Igual ao usado no exemplo List*/
        Iterator<Double> iterator = notas.iterator();
        double soma = 0d;
        while(iterator.hasNext()){
            double next = iterator.next();
            soma += next;

        }
        System.out.println("Exiba a soma dos valores: " + soma);

        System.out.println("Exiba a média das notas: " + (soma/ notas.size()));//para saber a quantidade o método é o 'size()'

        System.out.println("Remova a nota 0.0: ");
        notas.remove(0d);//remove é o método para remover
        System.out.println(notas);

//        System.out.println("Remova a nota da posição 0: ");//Não posso fazer porque eu não tenho como saber qual é o elemento da posição zero

        System.out.println("Remova as notas menores que 7 e exiba a nova lista: ");
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()){
            double next = iterator1.next();
            if (next < 7) iterator1.remove();
        }
        System.out.println(notas);

        System.out.println("Exiba todas as notas na ordem em que foram informados: ");//Aqui temos que usar o LinkedHashSet
        Set<Double> notas2 = new LinkedHashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas2);//Aqui podemos ver que ele NÃO repete os elementos (nota 7)

        System.out.println("Exiba todas as notas em ordem crescente: ");
        Set<Double> notas3 = new TreeSet<>(notas2);//só posso fazer isso porque é Double e tem o Comparable
        System.out.println(notas3);

        System.out.println("Apague todo o conjunto: ");
        notas.clear();//também poderia ser dessa maneira 'notas.removeAll(notas);'
        System.out.println("Confira se o conjunto está vazio: " + notas.isEmpty()); // devolvendo um boolean
        // Também poderia ser 'System.out.println("Confira se o conjunto está vazio: " + notas);' devolvendo '[]'




    }
}
