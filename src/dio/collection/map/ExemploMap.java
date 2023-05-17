package dio.collection.map;

import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {

        /* Dados os modelos de carros e seus consumos médios, faça:
        modelo = gol - consumo = 14.4 km/l
        modelo = uno - consumo = 15.6 km/l
        modelo = mobi - consumo = 16.1 km/l
        modelo = hb20 - consumo = 14.5 km/l
        modelo = kwid - consumo = 16.6 km/l
        * */

//        Map carrosPopulares2020 = new HashMap(); //antes do java 5
//        Map<String, Double> carrosPopulares = new HashMap<>(); //Generics(jdk5) - Diamond
//        HashMap<String, Double> carrosPopulares = new HashMap<>();
//        HashMap<String, Double> carrosPopulares = Map.of("gol", 14.4, "uno", 15.6, "mobi", 16.1, "hb20", 14.5, "kwid", 16.6);

        System.out.println("Crie um dicionário que relacione os modelos e seus respectivos consumos: ");
        HashMap<String, Double> carrosPopulares = new HashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        /*A ordem de saída dos elementos não é igual a ordem de inserção*/
        System.out.println(carrosPopulares);//tambem poderíamo passar '(carroPopulares.toString());'

        System.out.println("Substitua o consumo do gol por 15.2 km/l: ");
        carrosPopulares.put("gol", 15.2);
        System.out.println(carrosPopulares);

        System.out.println("Confira se o modelo tucson está no dicionário: " + carrosPopulares.containsKey("tucson"));
//    if (carrosPopulares.containsKey("tucson") == false) System.out.print("Não está");
        //'.containskeys()' Passamos o objeto como parâmetro neste método, ele devolve como retorno um boolean.

        System.out.println("Exiba o consumo do uno: " + carrosPopulares.get("uno"));

//        System.out.println("Exiba o terceiro modelo adicionado: ");
//        Assim como no Set, eu não tenho como saber a posição. Portanto, não podemos fazer.

        System.out.println("Exiba os modelos: ");// o método '.keySet()' retorna um Set
        Set<String> modelos = carrosPopulares.keySet();// criei um variável para receber o método.
//        String modelos = carrosPopulares.keySet().toString(); também é uma opção de criação da variável que terá a lista.
        System.out.println(modelos);

        System.out.println("Exiba os consumos dos carros: ");
        Collection<Double> consumos = carrosPopulares.values();//Esse método retorna collections
        System.out.println(consumos);

        System.out.println("Exiba o modelo mais econômico e seu consumo: ");
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();// O método '.entrySet()'retorna um Set. Criamos uma váriavel para receber esse set
        String modeloMaisEficiente = "";

        for (Map.Entry<String, Double> entry : entries) {
            if (entry.getValue().equals(consumoMaisEficiente)) {
                modeloMaisEficiente = entry.getKey();
                System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + " - " + consumoMaisEficiente);


            }

        }

        System.out.println("Exiba o modelo menos econômico e seu consumo: ");// É preciso trabalhar com a chave e o valor separadamente.

        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());//criei uma variável que recebe o método
    /*    Set<Map.Entry<String, Double>> entries1 = carrosPopulares.entrySet();//O método '.entry.Set()' me retorna um Set, que por sua vez me permite manipular chaves e valores separadamente.
        A linha de código acima foi comentada porque já tem acima. Bastou apenas colocar o laço diretamente.*/
        String modeloMenosEficiente = "";//só para controle;
        for (Map.Entry<String, Double> entry: carrosPopulares.entrySet()) {//criamos o foreach com o tipo que já existia ('tipo' 'nome da variavel': 'set')
            if (entry.getValue().equals(consumoMenosEficiente)) {//"se o meu entry.valor.igual(ao menosEficiente)
                modeloMenosEficiente = entry.getKey();
                System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " - " + consumoMenosEficiente);
            }
        }
            //"Exiba a soma dos consumos: ". Devemos criar uma variável que recebe o iterator
            Iterator<Double> iterator = carrosPopulares.values().iterator();//eu consigo chamar o método 'iterator()' porque é uma Collection
            Double soma = 0d;
            while (iterator.hasNext()){ //
                soma += iterator.next();
            }
            System.out.println("Exiba a soma dos consumos: " + soma);

        System.out.println("Exiba a média dos consumos deste dicionário de carros: " + (soma/carrosPopulares.size()));

        System.out.println("Remova os modelos com o consumo igual 15.6 km/l: ");
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while(iterator1.hasNext()) {
            if(iterator1.next().equals(15.6)) iterator1.remove();
        }
        System.out.println(carrosPopulares);

        System.out.println("Exiba os carros na ordem em que foram informados: ");//Para ordem, nós devemos usar a implementação LinkedHashMap
        /*Implementando a LinkedHashMAp*/
        LinkedHashMap<String, Double> carrosPopulares1 = new LinkedHashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares1);// também poderíamos usar '(carrosPopulares1.toString())'

        System.out.println("Exiba o dicionário ordenado pelo modelo: ");//"o modelo é a chave, quem ordena a chave é o TreeMap
        /*criando o TreeMap*/
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2.toString());

        System.out.println("Apague o conjunto de carros: ");
        carrosPopulares.clear();
        System.out.println(carrosPopulares);

        System.out.println("Confira se o dicionário está vazio: " + carrosPopulares.isEmpty());



    }

    }
