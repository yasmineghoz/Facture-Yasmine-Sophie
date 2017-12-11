package facture;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Facture {
    
    private Date emission ;
    private int numero ;
    private Client destinataire ;
    private List<LigneFacture> liste ;

    public Facture(Client destinataire, Date emission, int numero) {
        this.destinataire = destinataire;
        this.emission = emission;
        this.numero = numero;
        this.liste = new ArrayList<>();
    }

    /**
     * Get the value of numero
     *
     * @return the value of numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Get the value of emission
     *
     * @return the value of emission
     */
    public Date getEmission() {
        return emission;
    }

    /**
     * Get the value of destinataire
     *
     * @return the value of destinataire
     */
    public Client getDestinataire() {
        return destinataire;
    }


    
    public void ajouteLigne(Article a, int nombre, float remise) {
        liste.add(new LigneFacture(nombre,this,a,remise));
   }
    
   public float montantTTC(float tauxTVA) {
       float res=0f;
       
         for( LigneFacture f : liste){
            res+= f.montantLigne();
         }
         return (1+tauxTVA)*res;
   }
   
   public void print(PrintStream out, float tva) {
         out.println("Numéro de facture : "+ numero);
         out.println("Date d'émission"+ emission);
         for (LigneFacture f : liste){
             out.println(f.toString());
         }
   }
   
}
