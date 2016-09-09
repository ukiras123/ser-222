
public interface StepIterator<E> {
	public void setStep(int s);
	
	public boolean hasNext();
	
	public E next();
	
	public void remove();
}
