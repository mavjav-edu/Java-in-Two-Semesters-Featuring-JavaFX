public class ComparisonTester
{
    public static void main(String[] args)
    {
           Ball ballObject = new Ball(10);
           Brick brickObject = new Brick(10, 10, 10);
           
           VolumeComparison<Ball, Brick> comparison = new VolumeComparison<>(ballObject, brickObject);
   
           switch(comparison.compareVolume())
           {
               case -1:  System.out.println("The second object has a larger volume");
                         break;
               case 1:   System.out.println("The first object has a larger volume");
                         break;
               case 0:  System.out.println("The volumes are the same");
           }                
    }

}