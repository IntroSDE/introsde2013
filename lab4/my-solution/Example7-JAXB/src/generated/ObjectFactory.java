//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.7 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2013.10.16 alle 10:17:30 AM CEST 
//


package generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Journal_QNAME = new QName("", "journal");
    private final static QName _Article_QNAME = new QName("", "article");
    private final static QName _Catalog_QNAME = new QName("", "catalog");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JournalType }
     * 
     */
    public JournalType createJournalType() {
        return new JournalType();
    }

    /**
     * Create an instance of {@link ArticleType }
     * 
     */
    public ArticleType createArticleType() {
        return new ArticleType();
    }

    /**
     * Create an instance of {@link CatalogType }
     * 
     */
    public CatalogType createCatalogType() {
        return new CatalogType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JournalType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "journal")
    public JAXBElement<JournalType> createJournal(JournalType value) {
        return new JAXBElement<JournalType>(_Journal_QNAME, JournalType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "article")
    public JAXBElement<ArticleType> createArticle(ArticleType value) {
        return new JAXBElement<ArticleType>(_Article_QNAME, ArticleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CatalogType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "catalog")
    public JAXBElement<CatalogType> createCatalog(CatalogType value) {
        return new JAXBElement<CatalogType>(_Catalog_QNAME, CatalogType.class, null, value);
    }

}
