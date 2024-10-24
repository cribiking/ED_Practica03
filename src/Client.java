public class Client {

    private int arribada;
    private int sortida;

    public Client(int arribada, int sortida){
        this.arribada = arribada;
        this.sortida = sortida;
    }

    public int tempsTotalCua(){
        return sortida - arribada;
    }

}
