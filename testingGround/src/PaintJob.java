public class PaintJob {
    public static void main(String[] args) {
        System.out.println(getBucketCount(2.75, 3.25, 2.5, 1));
    }

    public static int getBucketCount(double area, double areaPerBucket){
        if(area < 0 || areaPerBucket <=0){
            return -1;
        }

        return (int) (Math.ceil(area/areaPerBucket));
    }
    public static int getBucketCount(double width, double height, double areaPerBucket){
        if(width <= 0 || areaPerBucket <=0 || height <=0){
            return -1;
        }
        double area = width * height;
        return getBucketCount(area,areaPerBucket);
    }

    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets){
        if(width <= 0 || areaPerBucket <=0 || height <=0 || extraBuckets<0){
            return -1;
        }
        return (getBucketCount(width, height, areaPerBucket) - extraBuckets);

    }
}
