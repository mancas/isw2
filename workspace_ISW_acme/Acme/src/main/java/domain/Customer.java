package domain;

import java.util.Collection;
import java.util.HashSet;


@SuppressWarnings("serial")
public class Customer extends Actor {
	
	private Collection<Registration> registers;
	
	public Customer()
	{
		super();
		this.registers = new HashSet<Registration>();
	}

	public Collection<Registration> getRegisters()
	{
		return this.registers;
	}
	
	public void setRegisters(Collection<Registration> registers)
	{
		this.registers = registers;
	}
	
	public void addRegister(Registration r)
	{
		this.registers.add(r);
		r.setCustomer(this);
	}
	
	public void removeRegister(Registration r)
	{
		this.registers.remove(r);
		r.setCustomer(null);
	}
}

