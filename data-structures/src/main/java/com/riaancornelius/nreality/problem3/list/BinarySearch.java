package com.riaancornelius.nreality.problem3.list;

import java.util.*;

/**
 * User: riaan.cornelius
 */
public class BinarySearch {

    public static int find(java.util.List<Integer> list, Integer intToFind, int imin, int imax) {
        // test if array is empty
        if (imax < imin) {
            // set is empty, so return value showing not found
            return -1;
        } else {
            // calculate midpoint to cut set in half
            int imid = midpoint(imin, imax);

            // three-way comparison
            if (list.get(imid) > intToFind){
                // key is in lower subset
                return find(list, intToFind, imin, imid - 1);
            } else if (list.get(imid) < intToFind) {
                // key is in upper subset
                return find(list, intToFind, imid + 1, imax);
            } else {
                // key has been found
                return imid;
            }
        }
    }

    private static int midpoint(int imin, int imax) {
        return imin + ((imax - imin) / 2);
    }

    public static int find(ArrayList<Integer> list, int intToFind) {
        return find(list, intToFind, 0, list.size()-1);
    }
}
