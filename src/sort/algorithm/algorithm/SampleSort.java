package sort.algorithm.algorithm;

public interface SampleSort {

    public void Sort_number_asc(int times);
    public void Sort_number_desc(int times);
    public void Sort_text_asc(int times);
    public void Sort_text_desc(int times);
	public int getDataSize();
	public Object getSortData(int line, int w);
}
