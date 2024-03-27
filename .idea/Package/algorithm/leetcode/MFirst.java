package Package.algorithm.leetcode;

import Package.other.M;

import javax.crypto.NullCipher;
import javax.naming.NameNotFoundException;
import java.math.BigInteger;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MFirst {
    public static void main(String[] args) {
//        rangeSumBST(new TreeNode(10, new TreeNode(5, null, null), new TreeNode(15, null, null)), 7, 15);
//        isAnagram("anagram", "nagaram");
//        uniqueOccurrences(new int[]{3, 5, -2, -3, -6, -6});
//        topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2);
//        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 1})));
//        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4})));
//        System.out.println(Arrays.toString(findErrorNums(new int[]{2 , 1})));
        System.out.println(fib(101));
    }

    //Input: root = [1,2,3,4,5]
    //Output: 3
    //Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
    //Example 2:
    //
    //Input: root = [1,2]
    //Output: 1
    public int diameterOfBinaryTree(TreeNode root) {
        Integer res = 0;
        getD(res++, root);
        return res;
    }

    private void getD(int res, TreeNode root) {
        if (null != root) {
            if (root.left == null && root.right == null) {
                res++;
            } else {
                getD(res, root.left);
                getD(res, root.right);
            }
        }
    }

    //Example 1:
    //
    //Input: nums = [3,2,3]
    //Output: 3
    //Example 2:
    //
    //Input: nums = [2,2,1,1,1,2,2]
    //Output: 2
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int maj = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) > maj) {
                res = i;
                maj = map.get(i);
            }
        }
        return res;
    }

    //Example 1:
    //
    //Input: nums = [3,2,2,3], val = 3
    //Output: 2, nums = [2,2,_,_]
    //Explanation: Your function should return k = 2, with the first two elements of nums being 2.
    //It does not matter what you leave beyond the returned k (hence they are underscores).
    //Example 2:
    //
    //Input: nums = [0,1,2,2,3,0,4,2], val = 2
    //Output: 5, nums = [0,1,4,0,3,_,_,_]
    //Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
    //Note that the five elements can be returned in any order.
    //It does not matter what you leave beyond the returned k (hence they are underscores).
    public int removeElement(int[] nums, int val) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }

    static long fib(int fi) {
        long[] ints = new long[fi + 1];
        if (fi > 1) {
            ints[0] = 0;
            ints[1] = 1;
            for (int i = 2; i <= fi; i++) {
                ints[i] = ints[i - 1] + ints[i - 2];
            }
        } else {
            return fi;
        }
        return ints[fi];
    }

    //Example 1:
//
//Input: nums = [1,2,2,4]
//Output: [2,3]
//Example 2:
//
//Input: nums = [1,1]
//Output: [1,2]
//
//Input: nums = [2,1]
//Output: [1,2]
    public static int[] findErrorNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return new int[]{};
    }

    //[1,2,3,1]
    public int rob(int[] nums) {
        int rob = 0;//1,3,
        int norob = 0;//1,1,
        for (int i = 0; i < nums.length; i++) {
            int newRob = norob + nums[i];
            int newNoRob = Math.max(norob, rob);
            rob = newRob;
            norob = newNoRob;
        }
        return Math.max(rob, norob);
    }
//    public int rob(int[] nums) {
//        int resi = 0;
//        int resj = 0;
//        int i = 0;
//        int j;
//        for (j = 1; j < nums.length; j++) {
//            resi += nums[i];//1,
//            resj += nums[j];//2,
//            i++;
//        }
//        return Math.max(resi, resj);
//    }
    //Example 1:
    //
    //Input: arr = [3,1,2,4]
    //Output: 17
    //Explanation:
    //Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. - 10
    //Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
    //Sum is 17.
    //Example 2:
    //
    //Input: arr = [11,81,94,43,3]
    //Output: 444
    // 1, 2, 3,
    //1,2,3/12,23/123 - 6
    // 1, 2, 3, 4, 5
    //1,2,3,4,5/12,23,34,45//123 - 6
    //n + n-1 + n-2...

    public int sumSubarrayMins(int[] arr) {
        int res = 0;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {

        }
        return res;
    }

    //Example 1:
//
//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
//Example 2:
//
//Input: nums = [1], k = 1
//Output: [1]
    //2 массива: один с числом, другой с количеством
    //берем число, если содержится уже, то во втором текущий элемент++, если нет, то добавляем элемент 1
    //надо уметь понимать последний элмент массива
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values);
        List<Integer> list = values.subList(0, k - 1);
        int[] ans = new int[list.size()];
        int j = 0;
        for (var entry : map.entrySet()) {
            if (list.contains(entry.getValue())) {
                ans[j++] = entry.getKey();
            }
        }
        return ans;
    }

    //Example 1:
//
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
//Example 2:
//
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
//Example 3:
//
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric characters.
//Since an empty string reads the same forward and backward, it is a palindrome.
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[\\W]|_", "");

        char[] array = s.toCharArray();
        int j = array.length - 1;
        int i = 0;
        while (i < j) {
            if (array[i] != array[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //Example 1:
//
//Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]
//Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n != 0) {
            int j = 0;
            int i;
            for (i = m; i < m + n; i++) {
                nums1[i] = nums2[j];
                j++;
            }
            boolean sort = false;
            while (!sort) {
                sort = true;
                for (i = 0; i < nums1.length - 1; i++) {
                    if (nums1[i] > nums1[i + 1]) {
                        j = nums1[i];
                        nums1[i] = nums1[i + 1];
                        nums1[i + 1] = j;
                        sort = false;
                    }
                }
            }
        }
    }

    //Example 1:
    //
    //Input: arr = [1,2,2,1,1,3]
    //Output: true
    //Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
    //Example 2:
    //
    //Input: arr = [1,2]
    //Output: false
    //Example 3:
    //
    //Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
    //Output: true
    public static boolean uniqueOccurrences(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }


    //Example 1:
//
//Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//Example 2:
//
//Input: strs = [""]
//Output: [[""]]
//Example 3:
//
//Input: strs = ["a"]
//Output: [["a"]]
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        res.addAll(map.values());
        return res;
//        if (strs.length == 1) {
//            return List<String>Collections.singletonList(Collections.singletonList(strs[0]));
//        }
//        List<List<String>> res = new ArrayList<>();
//
//        for (int i = 0; i < strs.length; i++) {
//            List<String> list = new ArrayList<>();
//            list.add(strs[i]);
//            for (int j = 0; j < strs.length; j++) {
//                if (i != j) {
//                    if (isAnagram2(strs[i], strs[j])) {
//                        list.add(strs[j]);
//                    }
//                }
//            }
//            res.add(list);
//        }
//        return res;
    }

//    private boolean isAnagram2(String s1, String s2) { //eat//bat
//        boolean temp = false;
//        for (int i = 0; i < s1.length(); i++) {
//            for (int j = 0; j < s2.length(); j++) {
//                if (s1.charAt(i) == s2.charAt(j)) {
//                    temp = true;
//                }
//                if (temp) {
//                    break;
//                }
//            }
//            if (!temp) {
//                return false;
//            }
//        }
//        return true;
//    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int current = target - nums[i];

            if (map.containsKey(current)) {
                return new int[]{map.get(current), i};
            }

            map.put(nums[i], i);
        }
        return null;
    }

    //Example 1:
//
//Input: s = "anagram", t = "nagaram"
//Output: true
//Example 2:
//
//Input: s = "rat", t = "car"
//Output: false
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        StringBuilder stringBuilder = new StringBuilder(t);
        List<String> strings1 = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            strings1.add(s.substring(i - 1, i));
        }
        for (int i = 1; i <= t.length(); i++) {
            if (!strings1.contains(stringBuilder.substring(i - 1, i))) {
                return false;
            } else {
                strings1.remove(stringBuilder.substring(i - 1, i));
            }
        }
        return true;
    }

//    Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
//    Output: true

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder buld = getBuld(root1);
        StringBuilder buld1 = getBuld(root2);
        return buld.compareTo(buld1) == 0;
    }

    private StringBuilder getBuld(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (null != root && null == root.left && null == root.right) {
            sb.append(root.val).append(".");
        }
        if (null != root.left) {
            sb.append(getBuld(root.left)).append(".");
        }
        if (null != root.right) {
            sb.append(getBuld(root.right)).append(".");
        }
        return sb;
    }
//    private void getBuld(TreeNode root, StringBuilder sb) {
//        if (null != root) {
//            sb.append(root.val);
//        }
//        if (null != root.left) {
//            getBuld(root.left, sb);
//        }
//        if (null != root.right) {
//            getBuld(root.right, sb);
//        }
//    }
    //Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
    //Output: 32
    //Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.

    //Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
    //Output: 23
    //Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
//    public static int rangeSumBST(TreeNode root, int low, int high) {
//        int res = 0;
//        getRange(root, low, high, res);
//        return res;
//    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val >= low && root.val <= high) {
            res += root.val;
        }
        if (null != root.left) {
            res += rangeSumBST(root.left, low, high);
        }
        if (null != root.right) {
            res += rangeSumBST(root.right, low, high);
        }
        return res;
    }

    private static void getRange(TreeNode root, int low, int high, int res) {
        if (root.val >= low && root.val <= high) {
            res += root.val;
        }
        if (null != root.left) {
            getRange(root.left, low, high, res);
        }
        if (null != root.right) {
            getRange(root.right, low, high, res);
        }
    }


    //Example 1:
    //
    //Input: nums = [1,2,3,1]
    //Output: true
    //Example 2:
    //
    //Input: nums = [1,2,3,4]
    //Output: false
    //Example 3:
    //
    //Input: nums = [1,1,1,3,3,4,3,2,4,2]
    //Output: true
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }

//Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
//Output: 120
//Explanation: The subset chosen is the first and fourth job.
//Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.

//    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
//        //мапа где ключ граница правая, значение должно содержать левую границу и профит
//        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
//        //цикл фор по трем массивам
//        //пихаем все в мапу
//
//
//    }

    //Example 1:
    //
    //Input: s = "0100"
    //Output: 1
    //Explanation: If you change the last character to '1', s will be "0101", which is alternating.
    //Example 2:
    //
    //Input: s = "10"
    //Output: 0
    //Explanation: s is already alternating.
    //Example 3:
    //
    //Input: s = "1111"
    //Output: 2
    //Explanation: You need two operations to reach "0101" or "1010".
    public int minOperations(String s) {
        char[] charArray = s.toCharArray();
        int res = 0;
        char next;
        char prev;
        for (int i = 1; i < charArray.length; i++) {
            next = charArray[i];
            prev = charArray[i - 1];
            if (next == prev) {
                res++;
                if (prev == '1') {
                    charArray[i] = '0';
                } else {
                    charArray[i] = '1';
                }
            }
        }
        return res;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean res = true;
        extracted(p, q, res);
        return res;
    }

    private void extracted(TreeNode p, TreeNode q, boolean res) {
        if ((null != p && null == q) || (null == p && null != q) || ((null != p && null != q) && (p.val != q.val))) {
            res = false;

        } else {
            if (null != p && null != q) {
                extracted(p.left, q.left, res);
                extracted(p.right, q.right, res);
            }
        }
    }

//    public int maximumWealth(int[][] accounts) {
//        for ()
//    }
//
//
//Example 1:
//
//Input: prices = [1,2,2], money = 3
//Output: 0
//Explanation: Purchase the chocolates priced at 1 and 2 units respectively. You will have 3 - 3 = 0 units of money afterwards. Thus, we return 0.
//Example 2:
//
//Input: prices = [3,2,3], money = 3
//Output: 3
//Explanation: You cannot buy 2 chocolates without going in debt, so we return 3.

    //prices =
//[41,1,28,2,92,97,1,87]
//money =
//68
    //=66
    public static int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int one = prices[0];
        int two = prices[1];
        if (one + two <= money) {
            return money - one - two;
        }
        return money;
//        TreeSet<Integer> set = new TreeSet<>();
//        for (int i : prices) {
//            if (i < money) {
//                set.add(i);
//            }
//        }
//        if (!set.isEmpty()) { // 1 1 1 2 3  -> 4
//            Iterator<Integer> iterator = set.iterator();
//            if (iterator.hasNext()) {
//                Integer one = iterator.next();
//                if (iterator.hasNext()) {
//                    Integer two = iterator.next();
//                    if (one + two <= money) {
//                        return money - one - two;
//                    }
//                }
//            }
//        }
//        return money;
    }

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public String destCity(List<List<String>> paths) {
        HashSet<String> endCities = new HashSet<>();
        for (List<String> strings : paths) {
            endCities.add(strings.get(1));
        }

        for (List<String> strings : paths) {
            if (endCities.contains(strings.get(0))) {
                endCities.remove(strings.get(0));
            }
        }
        if (!endCities.isEmpty()) {
            return endCities.stream().findFirst().get();
        }
        return "";
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.

    //Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder list11 = get1(new StringBuilder(), l1);//243 //9,9,9,9,9,9,9
        StringBuilder list22 = get1(new StringBuilder(), l2);//564 //9,9,9,9
        list11 = list11.reverse(); //342
        list22 = list22.reverse(); //465

        BigInteger res = new BigInteger(list11.toString()).add(new BigInteger(list22.toString())); //807
        String resString = res.toString();
        return getRes(resString);
    }

    private static ListNode getRes(String resString) { //мб через массив
        if (resString.length() == 1) {
            return new ListNode(Integer.valueOf(resString.substring(0)));
        }
        return prepareNext(new ListNode(Integer.valueOf(resString.substring(0, 1))), resString, 1);
    }

    public static ListNode prepareNext(ListNode child, String resString, int count) {
        if (count < resString.length()) {
            ListNode current = new ListNode(Integer.valueOf(resString.substring(count, count + 1)), child);
            return prepareNext(current, resString, count + 1);
        } else {
            return child;
        }
    }

    private static StringBuilder get1(StringBuilder builder, ListNode l) {
        if (l != null) {
            builder.append(l.val);
            return get1(builder, l.next);
        } else {
            return builder;
        }
    }

//    //метод должн вернуть или число или налл, если налл то ставим налл
//    //если число то надо создать новую ноду
//    public Integer getInt(String resString, ListNode l) {
//        for (int i = resString.length() - 1; i > 0; i--) {
//            ListNode node1 = new ListNode(Integer.valueOf(resString.substring(i - 1, i)), prepareNext(resString));
//        }
//        if (resString == null || resString.isEmpty()) {
//            return null;
//        }
//        return 0;
//    }


    //Example 1:
    //
    //Input: n = 4
    //Output: 10
    //Explanation: After the 4th day, the total is 1 + 2 + 3 + 4 = 10.
    //Example 2:
    //
    //Input: n = 10
    //Output: 37
    //Explanation: After the 10th day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37. Notice that on the 2nd Monday, Hercy only puts in $2.
    //Example 3:
    //
    //Input: n = 20
    //Output: 96
    //Explanation: After the 20th day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8) = 96.
    public int totalMoney(int n) {
        int res = 0;
        int weeks = n / 7;
        int lastDays = n % 7;

        for (int i = 1; i <= (n > 7 ? 7 : n); i++) {

            res += i;
        }
        return res;
    }

    //7... 3 + 2 + 1 = 6.
    //14... 7 + 3 + 2 + 1 = 13.
    //3
    public static int numberOfMatches(int n) {
        int res = 0;
        int temp = n;
        while (temp != 1) {
            if (n % 2 == 0) {
                n = temp / 2;
                temp -= n;
                res += n;
            } else {
                n = Math.round(temp / 2);
                temp -= n;
                res += n;
            }
        }
        return res;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String num = String.valueOf(x);
        char[] chars = num.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < chars.length - 1 && j > 0) {
            if (chars[i] != chars[j]) {
                return false;
            }
            if (i + 1 != j) {
                break;
            }
            i++;
            j--;
        }
        return true;
    }

    public static String largestGoodInteger(String num) {
        int res = -1;
        int i;
        StringBuilder builder = new StringBuilder();
        for (i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                res = Math.max(res, num.charAt(i));
            }
        }
        if (res != -1) {
            return builder.append(res).append(res).append(res).toString();
        }
        return "";
    }

//    public boolean canBeIncreasing(int[] nums) {
//        boolean res1 = true;
//        int j = nums.length - 1;
//        for (int i = 0; i < nums.length - 2; i++) {
//            if (nums[i] < nums[i] + 1) {
//                int[] newNums = {}
//                canBeIncreasing(nums.clone());
//                res1 = false;
//                break;
//            }
//        }
//        return res1;
//    }


//
//    Input: s = "III"
//    Output: 3
//    Explanation: III = 3.

//    Input: s = "LVIII"
//    Output: 58
//    Explanation: L = 50, V= 5, III = 3.

    //Input: s = "MCMXCIV"
    //Output: 1994
    //Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

    public int romanToInt(String s) {
        int res = 0;

        Map<Character, Integer> mapOfSymbol = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        for (int i = 0; i < s.length(); i++) {
            int current = mapOfSymbol.get(s.charAt(i));
            if ((i != s.length() - 1) && (mapOfSymbol.get(s.charAt(i + 1)) > current)) {
                current = mapOfSymbol.get(s.charAt(i + 1)) - current;
                i++;
            }
            res = res + current;
        }
        return res;
    }

//    public int[] twoSum(int[] nums, int target) {
//        int[] res = {0, 0};
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (i != j && (nums[i] + nums[j] == target)) {
//                    res = new int[]{i, j};
//                }
//            }
//        }
//        return res;
//    }

    public static int[] bubbleSort(int[] arr) {
        boolean sorted = false;                              //флаг что все отсортировано
        int temp;                                            //внутреняя переменная
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {    //проход по всему массиву
                if (
                        Integer.toBinaryString(arr[i]).replace("0", "").length()
                                >
                                Integer.toBinaryString(arr[i + 1]).replace("0", "").length()
                ) {                //провряем что предыдущий больше следующего
                    temp = arr[i];                        //если больше то присваиваем пред.эл. временной переменной
                    arr[i] = arr[i + 1];                  //меняем текущую переменную на следующую
                    arr[i + 1] = temp;                      // меняем следующую переменную на временную
                    sorted = false;                         //повторяем
                }
            }
        }
        return arr;
    }

    //Example 1:
//
//Input: s = "abbcccaa"
//Output: 13
//Explanation: The homogenous substrings are listed as below:
//"a"   appears 3 times.
//"aa"  appears 1 time.
//"b"   appears 2 times.
//"bb"  appears 1 time.
//"c"   appears 3 times.
//"cc"  appears 2 times.
//"ccc" appears 1 time.
//3 + 1 + 2 + 1 + 3 + 2 + 1 = 13.
//Example 2:
//
//Input: s = "xy"
//Output: 2
//Explanation: The homogenous substrings are "x" and "y".
//Example 3:
//
//Input: s = "zzzzz"
//Output: 15
    public int countHomogenous(String s) {
        int res = 0;

        char[] strings = s.toCharArray();
        for (int i = 0; i < strings.length; i++) {
            char j = strings[i];
            for (int n = 0; n < strings.length; n++) {

            }
        }
        return res;
    }
}
