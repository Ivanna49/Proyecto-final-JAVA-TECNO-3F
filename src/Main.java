import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear más armas
        ArmaCorta pistola1 = new ArmaCorta("Glock 17", 9, 50, EstadoArma.EN_USO, true);
        ArmaCorta pistola2 = new ArmaCorta("Beretta 92", 7, 40, EstadoArma.EN_MANTENIMIENTO, false);
        ArmaCorta pistola3 = new ArmaCorta("Smith & Wesson M&P", 9, 45, EstadoArma.EN_USO, false);
        ArmaCorta pistola4 = new ArmaCorta("Sig Sauer P320", 9, 55, EstadoArma.NUEVA, true);

        ArmaLarga rifle1 = new ArmaLarga("Remington 700", 12, 300, EstadoArma.EN_USO, true, "Tirador designado", 4);
        ArmaLarga rifle2 = new ArmaLarga("Winchester 70", 9, 250, EstadoArma.NUEVA, false, "Patrullaje rural", 2);
        ArmaLarga rifle3 = new ArmaLarga("FN SCAR", 7.62, 400, EstadoArma.EN_USO, true, "Operaciones especiales", 5);
        ArmaLarga rifle4 = new ArmaLarga("HK G36", 5.56, 350, EstadoArma.EN_MANTENIMIENTO, true, "Control de disturbios", 3);
        ArmaLarga rifle5 = new ArmaLarga("Mossberg 500", 12, 150, EstadoArma.EN_USO, false, "Control de multitudes", 1);

        // Crear más policías
        Policia policia1 = new Policia("Juan", "Pérez", "P001", pistola1);
        Policia policia2 = new Policia("Ana", "Gómez", "P002", pistola2);
        Policia policia3 = new Policia("Carlos", "López", "P003", rifle1);
        Policia policia4 = new Policia("María", "Rodríguez", "P004", rifle2);
        Policia policia5 = new Policia("Luis", "Martínez", "P005", pistola3);
        Policia policia6 = new Policia("Laura", "Fernández", "P006", rifle3);
        Policia policia7 = new Policia("Pedro", "García", "P007", pistola4);
        Policia policia8 = new Policia("Sofía", "Díaz", "P008", rifle4);
        Policia policia9 = new Policia("Miguel", "Sánchez", "P009", rifle5);

        // Escuadrón Alfa
        List<Policia> policiasEscuadronA = new ArrayList<>();
        policiasEscuadronA.add(policia1);
        policiasEscuadronA.add(policia3);
        policiasEscuadronA.add(policia6);

        List<Arma> armasEscuadronA = new ArrayList<>();
        armasEscuadronA.add(pistola1);
        armasEscuadronA.add(rifle1);
        armasEscuadronA.add(rifle3);

        Escuadron escuadronA = new Escuadron("Escuadrón Alfa", "Comisaría Central", policiasEscuadronA, armasEscuadronA);

        // Escuadrón Beta
        List<Policia> policiasEscuadronB = new ArrayList<>();
        policiasEscuadronB.add(policia2);
        policiasEscuadronB.add(policia4);
        policiasEscuadronB.add(policia5);
        policiasEscuadronB.add(policia8);

        List<Arma> armasEscuadronB = new ArrayList<>();
        armasEscuadronB.add(pistola2);
        armasEscuadronB.add(rifle2);
        armasEscuadronB.add(pistola3);
        armasEscuadronB.add(rifle4);

        Escuadron escuadronB = new Escuadron("Escuadrón Beta", "Comisaría Norte", policiasEscuadronB, armasEscuadronB);

        // Escuadrón Gamma
        List<Policia> policiasEscuadronG = new ArrayList<>();
        policiasEscuadronG.add(policia7);
        policiasEscuadronG.add(policia9);

        List<Arma> armasEscuadronG = new ArrayList<>();
        armasEscuadronG.add(pistola4);
        armasEscuadronG.add(rifle5);

        Escuadron escuadronG = new Escuadron("Escuadrón Gamma", "Comisaría Oeste", policiasEscuadronG, armasEscuadronG);

        // Mostrar información de los escuadrones
        System.out.println("=== INFORMACIÓN DE LOS ESCUADRONES ===");
        System.out.println(escuadronA);
        System.out.println(escuadronB);
        System.out.println(escuadronG);

        // Comparación de armas largas
        System.out.println("\n=== COMPARACIÓN DE ARMAS LARGAS ===");
        System.out.println("Comparación entre " + rifle1.getMarca() + " (Nivel " + rifle1.getNivel() +
                ") y " + rifle3.getMarca() + " (Nivel " + rifle3.getNivel() + "):");
        if (rifle1.esMayorQue(rifle3)) {
            System.out.println(rifle1.getMarca() + " es de mayor nivel que " + rifle3.getMarca());
        } else if (rifle3.esMayorQue(rifle1)) {
            System.out.println(rifle3.getMarca() + " es de mayor nivel que " + rifle1.getMarca());
        } else {
            System.out.println("Ambas armas tienen el mismo nivel");
        }

        System.out.println("\nComparación entre " + rifle2.getMarca() + " (Nivel " + rifle2.getNivel() +
                ") y " + rifle5.getMarca() + " (Nivel " + rifle5.getNivel() + "):");
        if (rifle2.esMayorQue(rifle5)) {
            System.out.println(rifle2.getMarca() + " es de mayor nivel que " + rifle5.getMarca());
        } else if (rifle5.esMayorQue(rifle2)) {
            System.out.println(rifle5.getMarca() + " es de mayor nivel que " + rifle2.getMarca());
        } else {
            System.out.println("Ambas armas tienen el mismo nivel");
        }
    }
}

enum EstadoArma {
    NUEVA,
    EN_USO,
    EN_MANTENIMIENTO,
    FUERA_DE_SERVICIO
}

abstract class Arma implements Comparable<Arma> {
    protected String marca;
    protected double calibre;
    protected int alcanceMetros;
    protected EstadoArma estado;
    protected Policia policiaAsignado;

    public Arma(String marca, double calibre, int alcanceMetros, EstadoArma estado) {
        this.marca = marca;
        this.calibre = calibre;
        this.alcanceMetros = alcanceMetros;
        this.estado = estado;
    }

    public void asignarPolicia(Policia policia) {
        this.policiaAsignado = policia;
    }

    public boolean estaEnCondiciones() {
        return estado == EstadoArma.EN_USO && calibre >= 9;
    }

    public String getMarca() {
        return marca;
    }

    public double getCalibre() {
        return calibre;
    }

    public int getAlcanceMetros() {
        return alcanceMetros;
    }

    public EstadoArma getEstado() {
        return estado;
    }

    public Policia getPoliciaAsignado() {
        return policiaAsignado;
    }

    @Override
    public String toString() {
        return "Arma: " + marca +
                " | Calibre: " + calibre +
                " | Alcance: " + alcanceMetros + "m" +
                " | Estado: " + estado +
                " | Asignada a: " + (policiaAsignado != null ? policiaAsignado.getNombreCompleto() : "Ninguno");
    }

    // Por defecto no comparo armas (puede overridearse en subclases)
    @Override
    public int compareTo(Arma otra) {
        return 0;
    }
}

class ArmaCorta extends Arma {
    private boolean esAutomatica;

    public ArmaCorta(String marca, double calibre, int alcanceMetros, EstadoArma estado, boolean esAutomatica) {
        super(marca, calibre, alcanceMetros, estado);
        this.esAutomatica = esAutomatica;
    }

    public boolean puedeDispararMas200m() {
        return alcanceMetros > 200;
    }

    public String esAutomatica() {
        return esAutomatica ? "SI" : "NO";
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Tipo: Corta" +
                " | Automática: " + esAutomatica() +
                " | Dispara +200m: " + (puedeDispararMas200m() ? "SI" : "NO");
    }
}

class ArmaLarga extends Arma {
    private boolean selloRENAR;
    private String descripcionUso;
    private int nivel;

    public ArmaLarga(String marca, double calibre, int alcanceMetros, EstadoArma estado,
                     boolean selloRENAR, String descripcionUso, int nivel) {
        super(marca, calibre, alcanceMetros, estado);
        this.selloRENAR = selloRENAR;
        this.descripcionUso = descripcionUso;
        this.nivel = nivel;
    }

    @Override
    public int compareTo(Arma otra) {
        if (otra instanceof ArmaLarga) {
            return Integer.compare(this.nivel, ((ArmaLarga) otra).nivel);
        }
        return 0;
    }

    public boolean esMayorQue(ArmaLarga otraArma) {
        return this.compareTo(otraArma) > 0;
    }

    public String tieneSelloRENAR() {
        return selloRENAR ? "SI" : "NO";
    }

    public String getDescripcionUso() {
        return descripcionUso;
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Tipo: Larga" +
                " | Sello RENAR: " + tieneSelloRENAR() +
                " | Nivel: " + nivel +
                " | Uso: " + descripcionUso;
    }
}

class Policia {
    private String nombre;
    private String apellido;
    private String legajo;
    private Arma armaAsignada;

    public Policia(String nombre, String apellido, String legajo, Arma armaAsignada) {
        if (armaAsignada == null) {
            throw new IllegalArgumentException("El policía debe tener un arma asignada");
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.armaAsignada = armaAsignada;
        armaAsignada.asignarPolicia(this);
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getLegajo() {
        return legajo;
    }

    public Arma getArmaAsignada() {
        return armaAsignada;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    @Override
    public String toString() {
        return "Policía: " + getNombreCompleto() +
                " | Legajo: " + legajo +
                " | Arma: " + armaAsignada.getMarca();
    }
}

class Escuadron {
    private String nombre;
    private String comisaria;
    private List<Policia> policias;
    private List<Arma> armas;

    public Escuadron(String nombre, String comisaria, List<Policia> policias, List<Arma> armas) {
        this.nombre = nombre;
        this.comisaria = comisaria;
        this.policias = policias;
        this.armas = armas;
    }

    public int cantidadIntegrantes() {
        return policias.size();
    }

    public int cantidadArmas() {
        return armas.size();
    }

    public int cantidadArmasEnCondiciones() {
        int count = 0;
        for (Arma arma : armas) {
            if (arma.estaEnCondiciones()) {
                count++;
            }
        }
        return count;
    }

    public String getNombre() {
        return nombre;
    }

    public String getComisaria() {
        return comisaria;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== ").append(nombre).append(" ===\n");
        sb.append("Comisaría: ").append(comisaria).append("\n");
        sb.append("Integrantes: ").append(cantidadIntegrantes()).append("\n");
        sb.append("Armas totales: ").append(cantidadArmas()).append("\n");
        sb.append("Armas en condiciones: ").append(cantidadArmasEnCondiciones()).append("\n");

        sb.append("\nDetalle de policías:\n");
        for (Policia policia : policias) {
            sb.append("- ").append(policia).append("\n");
        }

        sb.append("\nDetalle de armas:\n");
        for (Arma arma : armas) {
            sb.append("- ").append(arma).append("\n");
        }

        return sb.toString();
    }
}