package taller04.logica;

import taller04.dominio.Certificacion;

public interface CertificacionVisitor {
    void visit(Certificacion certificacion);
}