package clean.operationconstruction;

import clean.entities.CalculationStatement;
import clean.exceptions.InvalidInformationEnteredException;
import clean.operationconstrution.OperationConstructor;
import clean.userinteraction.UserInteractor;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class OperationConstructorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private UserInteractor userInteractor;

    @InjectMocks
    private OperationConstructor operationConstructor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void fails_whenInvalidOperationProvided() throws Exception {
        expectedException.expect(InvalidInformationEnteredException.class);
        expectedException.expectMessage("Wrong operation");
//        when(userInteractor.writeAndGetResponse("Enter operation")).thenReturn("Not valid operation");
        when(userInteractor.writeAndGetResponse("Enter operation")).thenReturn("8"); //thenReturn("-")

        operationConstructor.fetchCalculationDetails();
    }

    @Test
    public void fails_whenInvalidFirstOperandProvided() throws Exception {
        expectedException.expect(InvalidInformationEnteredException.class);
        expectedException.expectMessage("Wrong first operand");

        when(userInteractor.writeAndGetResponse("Enter operation")).thenReturn("SUBTRACTION");
        when(userInteractor.writeAndGetResponse("Enter first operand")).thenReturn("m8");

        operationConstructor.fetchCalculationDetails();
    }

    @Test
    public void fails_whenInvalidSecondOperandProvided() throws Exception {
        expectedException.expect(InvalidInformationEnteredException.class);
        expectedException.expectMessage("Wrong second operand");

        when(userInteractor.writeAndGetResponse("Enter operation")).thenReturn("SUBTRACTION");
        when(userInteractor.writeAndGetResponse("Enter first operand")).thenReturn("8");
        when(userInteractor.writeAndGetResponse("Enter second operand")).thenReturn("m8");

        operationConstructor.fetchCalculationDetails();
    }
}
