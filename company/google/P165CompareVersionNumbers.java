package company.google;

public class P165CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String [] versionsList1 = version1.split("\\.");
        String [] versionsList2 = version2.split("\\.");
        int i=0, j=0;
        while ( i < versionsList1.length && j < versionsList2.length){
            int val1= Integer.parseInt(versionsList1[i]);
            int val2 = Integer.parseInt(versionsList2[j]);
            if ( val1 == val2){
                i++;
                j++;
            } else if ( val1 > val2 ){
                return 1;
            } else {
                return -1;
            }
        }
        while ( i < versionsList1.length){
            if ( Integer.parseInt(versionsList1[i++]) > 0) return 1;
        }
        while ( j < versionsList2.length){
            if ( Integer.parseInt(versionsList2[j++]) > 0) return -1;
        }
        return 0;
    }

    public int compareVersionConcise(String version1, String version2) {
        String[] versions1 = version1.split("\\.");
        String[] versions2 = version2.split("\\.");
        int maxLength = Math.max(versions1.length, versions2.length);

        for (int i = 0; i < maxLength; i++) {
            int num1 = i < versions1.length ? Integer.parseInt(versions1[i]) : 0;
            int num2 = i < versions2.length ? Integer.parseInt(versions2[i]) : 0;
            if (num1 != num2) {
                return num1 > num2 ? 1 : -1;
            }
        }
        return 0;
    }

}
