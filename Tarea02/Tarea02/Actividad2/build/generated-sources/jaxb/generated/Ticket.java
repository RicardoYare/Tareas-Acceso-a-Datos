

package generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lineas">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="linea" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="concepto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="unidades" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="precio_unitario" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="importe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "lineas"
})
@XmlRootElement(name = "ticket")
public class Ticket {

    @XmlElement(required = true)
    protected Ticket.Lineas lineas;

    /**
     * Obtiene el valor de la propiedad lineas.
     * 
     * @return
     *     possible object is
     *     {@link Ticket.Lineas }
     *     
     */
    public Ticket.Lineas getLineas() {
        return lineas;
    }

    /**
     * Define el valor de la propiedad lineas.
     * 
     * @param value
     *     allowed object is
     *     {@link Ticket.Lineas }
     *     
     */
    public void setLineas(Ticket.Lineas value) {
        this.lineas = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="linea" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="concepto" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="unidades" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="precio_unitario" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="importe" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "linea",
        "total"
    })
    public static class Lineas {

        @XmlElement(required = true)
        protected List<Ticket.Lineas.Linea> linea;

        public void setLinea(List<Linea> linea) {
            this.linea = linea;
        }
        @XmlElement(required = true)
        protected String total;

        /**
         * Gets the value of the linea property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the linea property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLinea().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Ticket.Lineas.Linea }
         * 
         * 
         */
        public List<Ticket.Lineas.Linea> getLinea() {
            if (linea == null) {
                linea = new ArrayList<Ticket.Lineas.Linea>();
            }
            return this.linea;
        }

        /**
         * Obtiene el valor de la propiedad total.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTotal() {
            return total;
        }

        /**
         * Define el valor de la propiedad total.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTotal(String value) {
            this.total = value;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="concepto" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="unidades" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="precio_unitario" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="importe" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "concepto",
            "unidades",
            "precioUnitario",
            "importe"
        })
        public static class Linea {

            @XmlElement(required = true)
            protected String concepto;
            @XmlElement(required = true)
            protected String unidades;
            @XmlElement(name = "precio_unitario", required = true)
            protected String precioUnitario;
            @XmlElement(required = true)
            protected String importe;

            /**
             * Obtiene el valor de la propiedad concepto.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getConcepto() {
                return concepto;
            }

            /**
             * Define el valor de la propiedad concepto.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setConcepto(String value) {
                this.concepto = value;
            }

            /**
             * Obtiene el valor de la propiedad unidades.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUnidades() {
                return unidades;
            }

            /**
             * Define el valor de la propiedad unidades.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUnidades(String value) {
                this.unidades = value;
            }

            /**
             * Obtiene el valor de la propiedad precioUnitario.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPrecioUnitario() {
                return precioUnitario;
            }

            /**
             * Define el valor de la propiedad precioUnitario.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPrecioUnitario(String value) {
                this.precioUnitario = value;
            }

            /**
             * Obtiene el valor de la propiedad importe.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getImporte() {
                return importe;
            }

            /**
             * Define el valor de la propiedad importe.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setImporte(String value) {
                this.importe = value;
            }

        }

    }

}
