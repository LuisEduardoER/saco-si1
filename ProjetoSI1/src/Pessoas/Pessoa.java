package Pessoas;

/**
 * Interface que estabelece o comportamento de uma pessoa na empresa
 *
 * @author Andressa Bezerra 20721005
 * @author Lenin da Nobrega 20711433
 * @author Niedja Roberta 20621165
 * @author Renata Braga 20721334
 * @author Tatyanne Lapa 20621176
 */
public interface Pessoa {

	public String getName();

	public String getEmail();

	public String getPhone();

	public void setName(String name);

	public void setEmail(String email);

	public void setPhone(String phone);
}
