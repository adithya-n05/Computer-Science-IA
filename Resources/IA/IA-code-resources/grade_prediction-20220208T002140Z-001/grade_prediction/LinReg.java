/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade_prediction;

/**
 *
 * @author sameer
 */
import java.util.*;

public class LinReg {

    private ArrayList<Double> args = new ArrayList<Double>();
    private int epoch;
    private int inputs = 1;
    public int thing;
    public double[][] data = new double[14][inputs + 1];
    // Each input has a weight. the weight for the first input in the first element in the array, and so on... 
    public double[] weights = new double[inputs];
    public double bias = Math.random();

    LinReg(ArrayList<Double> args, int epoch) {
        this.args = args;
        this.epoch = epoch;
        thing = args.size();

//default value
        loadData();

    }

    LinReg(ArrayList<Double> args) {
        this.args = args;
        this.epoch = 5;
        thing = args.size();//default value
        loadData();

    }

    public void loadData() {

        for (int i = 0; i < args.size(); i++) {
            data[i][0] = (double) i;
        }
        for (int i = 0; i < args.size(); i++) {
            data[i][1] = (double) args.get(i);
        }
        for (int i = 0; i < inputs; i++) {
            weights[i] = Math.random();
        }

    }

    public ArrayList<Double> predict() {

        fit(epoch, 0.01);

        ArrayList<Double> variables = new ArrayList<Double>();
        for (double b : weights) {

            variables.add(b);
        }
        variables.add(bias);
        
        return variables;

    }

    public double cost() {
        double cost = 0;
        for (int k = 0; k < args.size(); k++) {
            double pred = 0;

            for (int i = 0; i < inputs; i++) {
                pred += weights[i] * data[k][i];
            }
            pred += bias;

            cost += Math.pow((pred - data[k][inputs]), 2) / (2 * args.size());
        }

        return cost;
    }

    public void gradientDescent(double alpha)// run until cost is near 0
    {
        for (int sid = 0; sid < 10000; sid++) {
            //we have w and b
            double[] preds = new double[inputs];//dpreds to weights in order
            double[] costs = new double[inputs + 1];//dcosts to weights
            double dpred_dbias = 1;
            double dCost_dpred = 0;
            // to minizize  sosts, we have to this equation costs = sum of (prediction-actual)^2/ data points. 
            //dcostsdpred * dpreddweight
            for (int u = 0; u < inputs; u++) {
                double sum = 0;
                for (int i = 0; i < args.size(); i++) { //loops through ArrayList to compute costs
                    double predictionFromWeights = data[i][u] * weights[u] + bias;
                    double y = data[i][1];
                    sum += (predictionFromWeights - y) * data[i][u]; //calculating derivating for weight
                }
                sum /= args.size();
                weights[u] -= alpha * sum; //updating the weights
            }
            double sum = 0;
            for (int u = 0; u < inputs; u++) {
                for (int i = 0; i < args.size(); i++) {
                    double predictionFromWeights = data[i][u] * weights[u] + bias;
                    double y = data[i][1];
                    sum += (predictionFromWeights - y);
                }
                sum /= args.size();
            }
            bias -= alpha * sum; //updating the bias
        }
        return;
    }

    public void fit(int epochs, double alpha) {
        for (int epoch = 0; epoch < epochs; epoch++) {
            gradientDescent(alpha);

        }

        return;
    }

}
