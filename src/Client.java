public class Client {

    private int arribada;
    private int sortida;

    public Client(int arribada){
        this.arribada = arribada;
    }

    public void setSortida(int sortida) {
        this.sortida = sortida;
    }

    public int tempsTotalCua(){
        return sortida - arribada;
    }

}
