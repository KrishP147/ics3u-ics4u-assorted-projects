import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Fun extends Application {

    @Override
    public void start(Stage primaryStage) {
        final int MAX_DEGREE = 10;
        final int MIN_DEGREE = 1;
        final int INFINITY = Integer.MAX_VALUE;
        final int NEGATIVE_INFINITY = Integer.MIN_VALUE;
        int userInput = 0;
        int degree = 0;
        int x = 0;
        String message = "";
        int[] initialArray = new int[MAX_DEGREE];
        int[] tangentArray = new int[2];

        programDescription();

        while (true) {
            message = "Please enter the degree of your polynomial (max degree of " + MAX_DEGREE + "):";
            degree = validateInput(userInput, MAX_DEGREE, MIN_DEGREE, message);
            message = "Please enter your coefficient:";
            initialArray = storeCoefficients(userInput, degree, message, INFINITY, NEGATIVE_INFINITY);
            message = "Please enter your x-coordinate";
            x = validateInput(userInput, INFINITY, NEGATIVE_INFINITY, message);
            tangentArray = calculateEquation(degree, initialArray, x);
            displayResult(initialArray, tangentArray, x);

            // Plot the polynomial
            plotPolynomial(initialArray, x, tangentArray);
        }
    }

    public void plotPolynomial(int[] coefficients, int x, int[] tangentCoefficients) {
        double[] dataX = new double[200]; // Array to store x-values
        double[] dataY = new double[200]; // Array to store y-values

        for (int i = 0; i < dataX.length; i++) {
            dataX[i] = i - 100 + x; // Generate x-values centered around x
            dataY[i] = evaluatePolynomial(coefficients, dataX[i]); // Evaluate polynomial at each x
        }

        // Create a LineChart
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

        // Create a series for the polynomial function
        XYChart.Series series = new XYChart.Series();

        // Add data points to the series
        for (int i = 0; i < dataX.length; i++) {
            series.getData().add(new XYChart.Data(dataX[i], dataY[i]));
        }

        // Add the series to the line chart
        lineChart.getData().add(series);

        // Add the tangent line
        double m = tangentCoefficients[0];
        double b = tangentCoefficients[1];
        double y1 = m * (x - 5) + b; // Calculate y1 using x - 5
        double y2 = m * (x + 5) + b; // Calculate y2 using x + 5
        series.getData().add(new XYChart.Data(x - 5, y1)); // Add point 5 units to the left of x
        series.getData().add(new XYChart.Data(x + 5, y2)); // Add point 5 units to the right of x

        // Create the scene and set it in the stage
        Scene scene = new Scene(lineChart, 800, 600);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Polynomial Graph");
        stage.show();
    }

    public static void programDescription() {
        JOptionPane.showMessageDialog(null, "This is a tool designed to calculate the equation of the tangent line for a point on any polynomial function (with degree less than 10).\nThe program will prompt users for the degree of the polynomial (between 1 and 10), the coefficients of each term, and the x-coordinate of the point.");
    }

    public static int validateInput(int input, int maxValue, int minValue, String message) {
        boolean validInput = false;
        String userInput = "";
        while (!validInput) {
            try {
                userInput = JOptionPane.showInputDialog(null, message);
                if (userInput == null)
                    goodBye();
                input = Integer.parseInt(userInput);
                if ((input < minValue || input > maxValue)) {
                    throw new Exception();
                }
                validInput = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "You entered invalid input. Please enter an integer" + "\nPlease try again!", "INPUT INVALID!",JOptionPane.ERROR_MESSAGE);
            } catch (Exception f) {
                JOptionPane.showMessageDialog(null, "You entered invalid input. " + "\nPlease enter a value between " + minValue + " and " + maxValue, "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
            }
        }
        return input;
    }

    public static int[] storeCoefficients(int inputtedCoefficients, int degree, String message, int maxValue, int minValue) {
        int[] storedCoefficients = new int[degree + 1];
        String writtenDegree = "";
        for (int i = degree; i >= 0; i--) {
            writtenDegree = " (degree " + i + ")";
            storedCoefficients[i] = validateInput(inputtedCoefficients, maxValue, minValue, (message + writtenDegree));
        }
        return storedCoefficients;
    }

    public static int[] calculateEquation(int degree, int[] initialCoefficients, int xCoordinate) {
        int[] derivativeCoefficients = new int[degree];
        double IROC = 0;
        double yCoordinate = initialCoefficients[0];
        int[] tangentValues = new int[2];
        for (int i = degree; i > 0; i--) {
            derivativeCoefficients[i - 1] = ((initialCoefficients[i]) * (i));
            IROC = IROC + ((derivativeCoefficients[i - 1]) * Math.pow(xCoordinate, (i - 1)));
            yCoordinate = yCoordinate + ((Math.pow(xCoordinate, i)) * (initialCoefficients[i]));
        }
        tangentValues[0] = (int) IROC;
        tangentValues[1] = (int) (yCoordinate - IROC * xCoordinate);

        return tangentValues;
    }

    public static void displayResult(int[] initialCoefficients, int[] tangentCoefficients, int x) {
        int m = tangentCoefficients[0];
        int b = tangentCoefficients[1];
        int y = m * x + b;
        String initialFunction = initialCoefficients[initialCoefficients.length - 1] + "x^" + (initialCoefficients.length - 1);
        for (int i = (initialCoefficients.length - 2); (i >= 0); i--) {
            initialFunction = initialFunction + " + " + initialCoefficients[i] + "x^" + (i);
        }
        String tangentEquation = m + "x + " + b;
        String message = "The equation of the tangent of\npoint (" + x + ", " + y + "), on the function " + initialFunction + "\nis " + tangentEquation + ".";
        JOptionPane.showMessageDialog(null, message, "RESULTS", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void goodBye() {
        JOptionPane.showMessageDialog(null, "Thank you for interacting with this program! Hope you had fun!");
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}