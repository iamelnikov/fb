package com.ee.fb.domain.invoice;

import com.ee.fb.domain.powerofattorney.PowerOfAttorney;
import com.ee.fb.domain.user.Person;

public interface WayBillInvoice {
	/**
	 * Поставщик
	 * @return
	 */
	public InvoiceShipperInfo getShipperInfo();
	/**
	 * Грузополучатель
	 * @return
	 */
	public InvoiceConsigneeInfo getConsigneeInfo();
	/**
	 * Плательщик
	 * @return
	 */
	public InvoicePayerInfo getPayerInfo();
	/**
	 * Лицо, разрешившее отпуск груза
	 * @return
	 */
	public Person getShippmentAllowedPerson();
	/**
	 * Лицо, выполнившее отпуск груза
	 * @return
	 */
	public Person getShippmentMadePerson();
	/**
	 * Главный бухгалтер
	 * @return
	 */
	public Person getChiefAccountant();
	/**
	 * Доверенность
	 * @return объект доверенности
	 */
	public PowerOfAttorney getPowerOfAttorney();
	/**
	 * Получить массу брутто
	 * @return double величина массы брутто
	 */
	public double getGrossMass();
	/**
	 * Получить массу нетто
	 * @return double величина массы нетто
	 */
	public double getNetMass();
	/**
	 * Лицо, принявшее груз 
	 * @return
	 */
	public Person getShippmentAcceptPerson();
	
}
