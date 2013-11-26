/**
 * Lengths.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package NET.webserviceX.www;

public class Lengths implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Lengths(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Angstroms = "Angstroms";
    public static final java.lang.String _Nanometers = "Nanometers";
    public static final java.lang.String _Microinch = "Microinch";
    public static final java.lang.String _Microns = "Microns";
    public static final java.lang.String _Mils = "Mils";
    public static final java.lang.String _Millimeters = "Millimeters";
    public static final java.lang.String _Centimeters = "Centimeters";
    public static final java.lang.String _Inches = "Inches";
    public static final java.lang.String _Links = "Links";
    public static final java.lang.String _Spans = "Spans";
    public static final java.lang.String _Feet = "Feet";
    public static final java.lang.String _Cubits = "Cubits";
    public static final java.lang.String _Varas = "Varas";
    public static final java.lang.String _Yards = "Yards";
    public static final java.lang.String _Meters = "Meters";
    public static final java.lang.String _Fathoms = "Fathoms";
    public static final java.lang.String _Rods = "Rods";
    public static final java.lang.String _Chains = "Chains";
    public static final java.lang.String _Furlongs = "Furlongs";
    public static final java.lang.String _Cablelengths = "Cablelengths";
    public static final java.lang.String _Kilometers = "Kilometers";
    public static final java.lang.String _Miles = "Miles";
    public static final java.lang.String _Nauticalmile = "Nauticalmile";
    public static final java.lang.String _League = "League";
    public static final java.lang.String _Nauticalleague = "Nauticalleague";
    public static final Lengths Angstroms = new Lengths(_Angstroms);
    public static final Lengths Nanometers = new Lengths(_Nanometers);
    public static final Lengths Microinch = new Lengths(_Microinch);
    public static final Lengths Microns = new Lengths(_Microns);
    public static final Lengths Mils = new Lengths(_Mils);
    public static final Lengths Millimeters = new Lengths(_Millimeters);
    public static final Lengths Centimeters = new Lengths(_Centimeters);
    public static final Lengths Inches = new Lengths(_Inches);
    public static final Lengths Links = new Lengths(_Links);
    public static final Lengths Spans = new Lengths(_Spans);
    public static final Lengths Feet = new Lengths(_Feet);
    public static final Lengths Cubits = new Lengths(_Cubits);
    public static final Lengths Varas = new Lengths(_Varas);
    public static final Lengths Yards = new Lengths(_Yards);
    public static final Lengths Meters = new Lengths(_Meters);
    public static final Lengths Fathoms = new Lengths(_Fathoms);
    public static final Lengths Rods = new Lengths(_Rods);
    public static final Lengths Chains = new Lengths(_Chains);
    public static final Lengths Furlongs = new Lengths(_Furlongs);
    public static final Lengths Cablelengths = new Lengths(_Cablelengths);
    public static final Lengths Kilometers = new Lengths(_Kilometers);
    public static final Lengths Miles = new Lengths(_Miles);
    public static final Lengths Nauticalmile = new Lengths(_Nauticalmile);
    public static final Lengths League = new Lengths(_League);
    public static final Lengths Nauticalleague = new Lengths(_Nauticalleague);
    public java.lang.String getValue() { return _value_;}
    public static Lengths fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        Lengths enumeration = (Lengths)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Lengths fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Lengths.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.webserviceX.NET/", "Lengths"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
