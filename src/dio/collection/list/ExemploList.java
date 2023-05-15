package dio.collection.list;

import java.util.ArrayList;
import java.util.List;

class ExemploList {
    public static void main(String[] args) {

        /*Formas de criar uma lista:*/
        // Dada uma lista com 7 notas de um aluno[7, 8.5, 9.3, 5, 7, 0, 3.6], faça:

       // List notas = new ArrayList(); //Forma de inicializar uma lista antes do java 5
         //ArrayList<Double> notas = new ArrayList();// Essa forma não é a recomendada.
        //List<Double> notas = new ArrayList<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
         /*List<Double> notas = Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));//Essa forma é limitada. Não podemos adicionar ou retirar.
         notas.add(10d);
         System.out.println(notas);
*/
        /*
        * List<Double> notas = List.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);// Essa forma também é imutável.
        * notas.add(1d);
        * notas.remove(5d)
        * System.out.println(notas);
        * */

        //1) Crie uma lista lista e adicione as sete notas
        System.out.println("Crie uma lista e adicione as sete notas: ");
        List<Double> notas = new ArrayList<>();// Generics(jdk 5) - Diamond Operator(jdk 7)"pode colocar o tipo dentro do ultimo diamond ou nao. O primeiro é obrigatório.
        notas.add(7.0);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5.0);
        notas.add(7.0);
        notas.add(0.0);
        notas.add(3.6);
        System.out.println(notas);//poderíamos passar,também, como argumento o '(notas.toString())'.

        //2)Exiba a posição da nota 5.0:
        System.out.println("Exiba a posição da nota 5.0: " + notas.indexOf(5d));// método 'indexOf' para passar a posição um elemento dentro de uma lista (retorna int)

        //3)Adicione na lista a posição da nota 8.0 na posição 4:
        System.out.println("Adicione na lista a posição da nota 8.0 na posição 4: ");
        notas.add(4,8d);//passamos como argumento a posição e o elemento (4, '8d' ou (double)8.0)
        System.out.println(notas);

        //4)Substitua a nota 5.0 pela nota 6.0:
        System.out.println("Substitua a nota 5.0 pela nota 6.0: ");
        notas.set(notas.indexOf(5d), 6d);//método de substituiçaõ. Passamos como argumento a posição e o elemento.
        System.out.println(notas);

        //5)Confira se a nota 5.0 está na lista:
        System.out.println("5)Confira se a nota 5.0 está na lista: " + notas.contains(5d));//esse método '.contains(object)' retorna um boolean

        //6)Exiba todas as notas na ordem em que foram informadas:
        /*System.out.println("Exiba todas as notas na ordem em que foram informadas: ");
        for (Double nota: notas) System.out.println(nota);*/

        }

    }


