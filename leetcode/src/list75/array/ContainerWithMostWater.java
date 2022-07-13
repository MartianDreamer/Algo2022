package list75.array;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int rs = Math.min(height[left], height[right]) * (right-left);
        while (left!=right) {
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            rs = Math.max(rs, Math.min(height[left], height[right]) * (right-left));
        }
        return rs;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
