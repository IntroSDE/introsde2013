//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.7 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2013.10.16 alle 10:17:30 AM CEST 
//


package generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per catalogType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="catalogType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}journal" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="journalTitle" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="publisher" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "catalogType", propOrder = {
    "journal"
})
public class CatalogType {

    protected List<JournalType> journal;
    @XmlAttribute(name = "journalTitle")
    protected String journalTitle;
    @XmlAttribute(name = "publisher")
    protected String publisher;

    /**
     * Gets the value of the journal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the journal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJournal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JournalType }
     * 
     * 
     */
    public List<JournalType> getJournal() {
        if (journal == null) {
            journal = new ArrayList<JournalType>();
        }
        return this.journal;
    }

    /**
     * Recupera il valore della proprietà journalTitle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJournalTitle() {
        return journalTitle;
    }

    /**
     * Imposta il valore della proprietà journalTitle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJournalTitle(String value) {
        this.journalTitle = value;
    }

    /**
     * Recupera il valore della proprietà publisher.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Imposta il valore della proprietà publisher.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublisher(String value) {
        this.publisher = value;
    }

}
