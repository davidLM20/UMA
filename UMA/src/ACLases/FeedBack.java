package ACLases;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : UMA
//  @ File Name : FeedBack.java
//  @ Date : 14/5/2020
//  @ Author : UMA_TEAM
//
//




public class FeedBack {
	public String calificacion;
	public String observacion;

    public FeedBack() {
    }

    public FeedBack(String calificacion, String observacion) {
        this.calificacion = calificacion;
        this.observacion = observacion;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public String toString() {
        return "FeedBack{" + "calificacion=" + calificacion + ", observacion=" + observacion + '}';
    }
        
}
