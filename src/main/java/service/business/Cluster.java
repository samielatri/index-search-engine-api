package service.business;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

/**
 * Created bu PacLab
 * User: sami
 * Date: 2/9/2021
 * Time: 2:39 PM
 * Package: service.business
 *
 * Class name: Map
 * Class description: A Map is a structured indexed representation of Terms and Documents.
 */
public class Cluster {
    // TODO: implement Map logic
    List<Document> documentList; // list of documents
    List<List<Pair<Integer, Integer>>> map; // content of cluster
    /*
    // representation of the map :
                        -------------------------------------
    key[0] ->  (num_doc):(occ)  |(num_doc):(occ)  |
    key[1] ->  (num_doc):(occ)  |(num_doc):(occ)  |
                        --------------------------------------
    What stands for what ? :
       num_doc : number of document
       occ : occurrence of the documentList[x] in the document of num_doc
  */
}
