import java.util.ArrayList;
import java.util.List;

public class MainClass {


    public static void main(String[] args) {
        String[][] arrDolar = Utils.getDolarMatrix();
        String[] fechaTemp = new String[3];
        DolarDiario dolarTemp;
        List<DolarDiario> dolarList = new ArrayList<DolarDiario>();
        
        for (int i=0; i<arrDolar.length; i++){
            dolarTemp = new DolarDiario();
            fechaTemp = arrDolar[i][0].split("-");
            dolarTemp.dia = Integer.parseInt(fechaTemp[0]);
            dolarTemp.mes = Integer.parseInt(fechaTemp[1]);
            dolarTemp.anio = Integer.parseInt(fechaTemp[2]);
            dolarTemp.valor = Integer.parseInt(arrDolar[i][1]);
            dolarTemp.fecha = arrDolar[i][0];
            dolarList.add(dolarTemp);
        }

        int i=0;
        List<DolarDiario> lst = new ArrayList<DolarDiario>();
        while(dolarList.get(i).anio >2022 || ( dolarList.get(i).anio == 2022 && dolarList.get(i).mes > 9)){
            if(dolarList.get(i).mes != dolarList.get(i+1).mes){
                lst.add(dolarList.get(i));
            }
            i++;
        }
        System.out.println("Cantidad de cuotas: " + lst.size());

        int total = 0;
        int cuota = 21299;
        for (i=0; i<lst.size(); i++){
            total += cuota/lst.get(i).valor;
            System.out.println(lst.get(i).fecha);
            System.out.println("" + cuota + "/" + lst.get(i).valor + " = " + cuota/lst.get(i).valor);
        }
        System.out.println(total);



    }

}