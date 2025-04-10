public class DistanciaDeEdicao {
    private static int iteracoes = 0;

    public static int substituir(String str1, String str2, int i, int j) {
        iteracoes++;
        return distanciaDeEdicao(str1, str2, i - 1, j - 1) + 1;
    }

    public static int insercao(String str1, String str2, int i, int j) {
        iteracoes++;
        return distanciaDeEdicao(str1, str2, i, j - 1) + 1;
    }

    public static int delecao(String str1, String str2, int i, int j) {
        iteracoes++;
        return distanciaDeEdicao(str1, str2, i - 1, j) + 1;
    }

    public static int distanciaDeEdicao(String str1, String str2, int i, int j) {
        iteracoes++;
        if (i < 0 && j < 0) return 0;
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;

        if (str1.charAt(i) == str2.charAt(j))
            return distanciaDeEdicao(str1, str2, i - 1, j - 1);

        return Math.min(
                Math.min(
                        substituir(str1, str2, i, j),
                        insercao(str1, str2, i, j)
                ),
                delecao(str1, str2, i, j)
        );
    }

    public static void main(String[] args) {
        String str1 = "casa";
        String str2 = "mesa";
        iteracoes = 0;
        int resultado = distanciaDeEdicao(str1, str2, str1.length() - 1, str2.length() - 1);
        System.out.println("Distância de edição: " + resultado);
        System.out.println("Número de iterações: " + iteracoes);
    }
}