public class VolumeComparison<T extends Calculatable, S extends Calculatable> 
{
    T first;
    S second;
   
    public VolumeComparison(T firstIn, S secondIn)
    {
        first = firstIn;
        second = secondIn;
    }

    public int compareVolume()
    {
        if(first.calculateVolume() < second.calculateVolume())
        {
            return -1;
        }
        else if(first.calculateVolume() > second.calculateVolume())
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}

