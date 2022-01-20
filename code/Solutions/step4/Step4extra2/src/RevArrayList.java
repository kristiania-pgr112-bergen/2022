package Solutions.step4.Step4extra2.src;

import java.util.ArrayList;

public class RevArrayList {
    public ArrayList<String> reverseArrayList(ArrayList<String> alist)
    {
        // Arraylist for storing reversed elements
        ArrayList<String> revArrayList = new ArrayList<>();
        for (int index = alist.size() - 1; index >= 0; index--) {
            // Append the elements in reverse order
            revArrayList.add(alist.get(index));
        }
        // Return the reversed arraylist
        return revArrayList;
    }

    public ArrayList<String> reverseArrayList2(ArrayList<String> alist)
    {
        // This solution requires no extra arraylist allocated
        for (int index = 0; index < alist.size() / 2; index++) {
            //temporarily store
            String temp = alist.get(index);
            alist.set(index, alist.get(alist.size() - index - 1));
            alist.set(alist.size() - index - 1, temp);
        }
        // Return the reversed arraylist
        return alist;
    }

    public ArrayList<String> reverseArrayList3(ArrayList<String> alist)
    {
        // This solution requires no extra arraylist allocated
        for(int i = 0, j = alist.size() - 1; i < j; i++) {
            alist.add(i, alist.remove(j));
        }
        return alist;
    }

    // Iterate through all the elements and print
    public void printElements(ArrayList<String> alist)
    {
        for(String item : alist) {
            System.out.print(item + "\n");
        }
    }
}
