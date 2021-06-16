package com.tw.academy;

import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class CashRegisterTest {

	private final String TEST = "test";

	@Test
	void should_process_execute_printing() {
		//given
		CashRegister cashRegister = new CashRegister(new Printer());
		Purchase purchase = new Purchase();
		//when
		cashRegister.process(purchase);
		//then
		//verify that cashRegister.process will trigger print
	}

	@Test
	void should_verify_trigger_print_method_when_call_process_method() {
		// given
		Printer printer = spy(Printer.class);
		Purchase purchase = mock(Purchase.class);
		CashRegister cashRegister = new CashRegister(printer);
//		when(purchase.asString()).thenReturn(TEST);
		given(purchase.asString()).willReturn(TEST);
		// when
		cashRegister.process(purchase);
		// then
		verify(printer, times(1)).print(TEST);
	}

}
