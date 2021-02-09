package service.business;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created bu PacLab
 * User: sami
 * Date: 2/9/2021
 * Time: 09:34 PM
 * Package: service.business
 */
public class Header {
    // attributes

    /**
     * Attribute name: headerMap
     * Attribute type: Map<String, Integer>
     * Attribute description: map which maps the column's name to its position in the vector
     */
    final Map<String, Integer> headerMap; // order of representation never changes

    /**
     * Attribute name: headerName
     * Attribute type: List<String>
     * Attribute description : list of headerName sorted by the order in which columns appear
     */
    final List<String> headerName; // order of representation never changes

    // constructors

    /**
     * Constructor
     * @param headerMap : headerMap
     * @param headerName : headerName
     */
    public Header(final Map<String, Integer> headerMap, final List<String> headerName) {
        this.headerMap = headerMap;
        this.headerName = headerName;
    } // Header constructor end

    // methods

    /**
     * @param o : Object to compare
     * @return true if objects are equals, false if not
     */
    @java.lang.Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } // if block end

        if (o == null || getClass() != o.getClass()) {
            return false;
        } // if block end

        Header header = (Header) o;

        if (!Objects.equals(headerMap, header.headerMap)) {
            return false;
        } // if block end

        return Objects.equals(headerName, header.headerName);

        /*
        if (headerMap != null ? !headerMap.equals(header.headerMap) : header.headerMap != null) return false;
        return headerName != null ? headerName.equals(header.headerName) : header.headerName == null;
         */
    } // equals end

    /**
     * @return int
     */
    @java.lang.Override
    public int hashCode() {
        int result = headerMap != null ? headerMap.hashCode() : 0;
        result = 31 * result + (headerName != null ? headerName.hashCode() : 0);
        return result;
    } // hashCode end

    // accessors

    /**
     * @return headerMap
     */
    public Map<String, Integer> getHeaderMap() {
        return headerMap;
    } // getHeaderMap end

    /**
     * @return headerName
     */
    public List<String> getHeaderName() {
        return headerName;
    } // getHeaderName end

    /**
     * @return a String describing the Header
     */
    @java.lang.Override
    public String toString() {
        return "Header{" +
                "headerMap=" + headerMap +
                ", headerName=" + headerName +
                '}';
    } // toString end
} // Header end
