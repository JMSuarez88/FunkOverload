package BackEnd;

public class Metar {
	private String[] airportRunways;
    private String[] tafResult;
    private String result;
    private double surfaceWindDegrees = 0;
    private int surfaceWindKnots = 0;
    private int ppVisibility;
    private boolean takeOffConfirmation = false;

    public Metar(String code){
        String aux;
        try {
        	this.airportRunways = new String().split(",");            
        	aux = HttpData.getHTML("http://www.smn.gov.ar/mensajes/index.php?observacion=taf&operacion=consultar&tipoEstacion=OACI&CODIGO_FIR=-1&CODIGO=" + code);
            result = aux.substring(aux.indexOf("class=\"result\"")+81,aux.indexOf("=<"));
            tafResult = result.split(" ");

            for(String s : tafResult)
                System.out.println(s);

            setSurfaceWind();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    // Meters
    public void setUpPPVisibility(){
        ppVisibility = Integer.parseInt(tafResult[5]);
    }
    public void checkCAVOK(){
        for (String s : tafResult){
            if(s.equals("CAVOK"))
                takeOffConfirmation = true;
        }
    }
    public void setSurfaceWind(){
        if(tafResult[4].length() == 7 && !tafResult[4].contains("VRB")){
            surfaceWindDegrees = Double.parseDouble(tafResult[3].substring(0,3));
            surfaceWindKnots = Integer.parseInt(tafResult[3].substring(3,5));
        }
    }

    public double crossWind(){
        double result = 360;
        for(String x : this.airportRunways){
            double rwDegrees = Double.parseDouble(x)*10;
            double aux;
            aux = surfaceWindKnots * Math.sin(Math.toRadians(surfaceWindDegrees) - Math.toRadians(rwDegrees));
            if(aux < result)
                result = aux;
        }

        return result;
    }

    public boolean crossWindDelay(){
        double crossWind = crossWind();
        if(crossWind > 30)
            return true;

        return false;
    }

    public boolean surfaceWindDelay(){
        if(surfaceWindKnots > 60)
            return true;

        return false;
    }
}
