package takeUForward.google;

public class AddTwoPolynomialsRepresentedAsLinkedLists {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode res = new PolyNode();
        PolyNode cur = res;
        while ( poly1 != null && poly2 != null ){
            if ( poly1.power == poly2.power) {
                if ( poly1.coefficient+ poly2.coefficient != 0){
                    cur.next = new PolyNode(poly1.coefficient+ poly2.coefficient , poly1.power);
                    cur = cur.next;
                }
                poly1 = poly1.next;
                poly2 = poly2.next;
            } else if ( poly1.power > poly2.power){
                if ( poly1.coefficient != 0) {
                    cur.next = new PolyNode(poly1.coefficient, poly1.power);
                    cur = cur.next;
                }
                poly1 = poly1.next;
            } else {
                if ( poly2.coefficient != 0) {
                    cur.next = new PolyNode(poly2.coefficient, poly2.power);
                    cur = cur.next;
                }
                poly2 = poly2.next;
            }

        }
        while ( poly1 != null){
            if ( poly1.coefficient != 0) {
                cur.next = new PolyNode(poly1.coefficient, poly1.power);
                cur = cur.next;
            }
            poly1 = poly1.next;
        }
        while ( poly2 != null){
            if ( poly2.coefficient != 0) {
                cur.next = new PolyNode(poly2.coefficient, poly2.power);
                cur = cur.next;
            }
            poly2 = poly2.next;
        }
        return res.next;
    }

    class PolyNode {
        public PolyNode(int coefficient, int power, PolyNode next) {
            this.coefficient = coefficient;
            this.power = power;
            this.next = next;
        }

        public PolyNode() {
        }

        public PolyNode(int coefficient, int power) {
            this.coefficient = coefficient;
            this.power = power;
        }

        int coefficient, power;
        PolyNode next = null;
    }
}
