package data_structures.strings;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Stack;

public class XMLToTree {
    public static TreeNode createXMLTree (String xml) throws XMLStreamException{
        InputStream is = new ByteArrayInputStream(xml.getBytes());
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(is);
        Stack<TreeNode> stack = new Stack<>();
        TreeNode last = null;
        while ( reader.hasNext() ){
           if ( reader.getEventType() == XMLStreamConstants.START_DOCUMENT
           || reader.getEventType() == XMLStreamConstants.SPACE
           || reader.getEventType() == XMLStreamConstants.END_DOCUMENT ){
               reader.next();
               continue;
           }
           else if ( reader.getEventType() == XMLStreamConstants.END_ELEMENT ){
               if ( !stack.empty() ){
                   last = stack.pop();
               }
               reader.next();
               continue;
           }

           if ( reader.getEventType() == XMLStreamConstants.START_ELEMENT ){
               TreeNode node = new TreeNode(reader.getLocalName());
               if ( !stack.isEmpty() ){
                   stack.peek().Children.add(node);
               }
               stack.push(node);
           }
           else if ( reader.getEventType() == XMLStreamConstants.CHARACTERS ){
               TreeNode node = new TreeNode(reader.getText());
               if (!stack.isEmpty()){
                   stack.peek().Children.add(node);
               }
           }
           reader.next();
        }
        return last;
    }

    public static void main(String[] args) {
        try {
            String xml = "<xml><data>hello world     </data>    <a><b></b><b><c></c></b></a></xml>";
            TreeNode result = createXMLTree(xml);
            print_tree(result,0);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void print_tree(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        for (int i = 0; i < depth; ++i) System.out.print("\t");
        System.out.print(root.text + "\n");
        for (TreeNode child : root.Children) {
            print_tree(child, depth + 1);
        }
    }
}
