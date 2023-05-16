package dio.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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

        //7)Exiba a terceira nota adicionada:
        System.out.println("Exiba a terceira nota adicionada: " + notas.get(2));//Usamos o método '.get', então passamos a posição que desejamos dentro do método
        System.out.println(notas.toString());//para verificar que a posição das notas

        //8)Exiba a menor nota:
        System.out.println("Exiba a menor nota: " + Collections.min(notas));//passar a colections com o método '.min' e passar a collection 'notas'como argumento desse método

        //9)Exiba a maior nota:
        System.out.println("Exiba a maior nota: " + Collections.max(notas));//'.max' para o maior elemento da collection

        //10)Exiba a soma dos valores:
        Iterator<Double> iterator = notas.iterator();//criação de variável do padrão iterator. Atalho: ctrl+alt+v
        double soma = 0d;
        while(iterator.hasNext()){ //laço que diz: "enquanto(iterator, tem próximo?)"
            Double next = iterator.next();//variavel next recebe o valor do iterator.next
            soma += next;//variavel soma para somar todos os valores recebidos pelo next
        }
        System.out.println("Exiba a soma dos valores: " + soma);

        //11)Exiba a média das notas:
        System.out.println("Exiba a média das notas: " + (soma/notas.size()));//size é o método que retorna o valor int de elementos.

        //12)Remova a nota 0.0:
        System.out.println("Remova a nota 0.0: ");
        notas.remove(0d);//método remove  com o objeto. Se eu colocar apenas o '0' ele removerá a posição 0.
        System.out.println("Novas notas: " + notas);

        //13)Remova a nota na posição 0:
        System.out.println("Remova a nota na posição 0: ");
        notas.remove(0);
        System.out.println("Novas notas: " + notas);

        //14)Remova as notas menores do que 7 e exiba a lista:
        System.out.println("Remova as notas menores do que 7 e exiba a lista: ");
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()) {
            double next = iterator1.next();
            if(next < 7) iterator1.remove();
        }
        System.out.println(notas);

        //15)Apague toda a lista:
        System.out.println("Apague toda a lista: ");
        notas.clear();//'notas.removeAll(notas);' foi o método que eu usei e funcionou também. Obtive como retorno '[]'
        System.out.println(notas);

        //16)Confira se a lista está vazia:
        System.out.println("Confira se a lista está vazia: " + notas.isEmpty());//esse método retorna um boolean, sendo true == empty




    }

    }


