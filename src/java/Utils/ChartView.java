package Utils;

import dao.PessoaDao;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import model.Pessoa;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LegendPlacement;
import org.primefaces.model.chart.PieChartModel;

@ManagedBean
public class ChartView implements Serializable
{

    private PieChartModel chartEstadoCivil;
    private PieChartModel chartGrauInstrucao;
    private PieChartModel chartFilhos;
    private BarChartModel chartIdade;
    private int chartIdadeMaxValue;
    private BarChartModel chartSalario;
    private double chartSalarioMaxValue;
    private final PessoaDao pessoaDao = new PessoaDao();

    @PostConstruct
    public void init()
    {
        this.chartIdadeMaxValue = 0;
        createPieModels();
    }

    public PieChartModel getChartEstadoCivil()
    {
        return this.chartEstadoCivil;
    }

    public PieChartModel getChartGrauInstrucao()
    {
        return this.chartGrauInstrucao;
    }

    public PieChartModel getChartFilhos()
    {
        return this.chartFilhos;
    }

    public BarChartModel getChartIdade()
    {
        return this.chartIdade;
    }

    public BarChartModel getChartSalario()
    {
        return this.chartSalario;
    }

    private void createPieModels()
    {
        this.chartEstadoCivilChart();
        this.createGrauInstrucaoChart();
        this.createIdadeChart();
        this.createNumeroFilhosChart();
        this.createSalarioChart();
    }

    private void chartEstadoCivilChart()
    {
        // Prepara o modelo do estado civil
        this.chartEstadoCivil = new PieChartModel();
        this.chartEstadoCivil.setTitle("Estado Civil");
        this.chartEstadoCivil.setDataFormat("value");
        this.chartEstadoCivil.setShowDataLabels(true);
        this.chartEstadoCivil.setLegendPosition("w");

        // Monta  o gráfico com seus valores
        for (String estadoCivil : this.pessoaDao.getEstadosCivis())
        {
            this.chartEstadoCivil.set(estadoCivil, this.pessoaDao.getNumberByEstadoCivil(estadoCivil));
        }
    }

    private void createGrauInstrucaoChart()
    {
        // Prepara o modelo do grau de instrução
        this.chartGrauInstrucao = new PieChartModel();
        this.chartGrauInstrucao.setTitle("Grau de Instrução");
        this.chartGrauInstrucao.setLegendPosition("w");
        this.chartGrauInstrucao.setDataFormat("value");
        this.chartGrauInstrucao.setShowDataLabels(true);
        this.chartGrauInstrucao.setFill(false);

        // Monta  o gráfico com seus valores
        for (String grauInstrucao : this.pessoaDao.getGrausInstrucao())
        {
            this.chartGrauInstrucao.set(grauInstrucao, this.pessoaDao.getNumberByGrauInstrucao(grauInstrucao));
        }
    }

    private void createNumeroFilhosChart()
    {
        // Prepara o modelo do estado civil
        this.chartFilhos = new PieChartModel();
        this.chartFilhos.setTitle("Número  de  filhos");
        this.chartFilhos.setDataFormat("value");
        this.chartFilhos.setShowDataLabels(true);
        this.chartFilhos.setLegendPosition("w");

        // Monta  o gráfico com seus valores
        for (int filhos : this.pessoaDao.getNumeroFilhos())
        {
            this.chartFilhos.set(String.valueOf(filhos), this.pessoaDao.getNumberByFilhos(filhos));
        }
    }

    private BarChartModel initIdadeChart()
    {
        BarChartModel modelo = new BarChartModel();
        for (Pessoa pessoa : this.pessoaDao.getPessoas())
        {
            ChartSeries pessoaChart = new ChartSeries();
            pessoaChart.setLabel(pessoa.getIdPessoa().toString());
            pessoaChart.set("Idade", pessoa.getIdadeAnos());
            modelo.addSeries(pessoaChart);

            if (pessoa.getIdadeAnos() > this.chartIdadeMaxValue)
            {
                this.chartIdadeMaxValue = pessoa.getIdadeAnos();
            }
        }

        return modelo;
    }

    private void createIdadeChart()
    {
        this.chartIdade = this.initIdadeChart();

        this.chartIdade.setTitle("Idade");
        this.chartIdade.setLegendPosition("ne");
        this.chartIdade.setLegendPlacement(LegendPlacement.OUTSIDEGRID);

        Axis xAxis = this.chartIdade.getAxis(AxisType.X);
        xAxis.setLabel("Pessoa");

        Axis yAxis = this.chartIdade.getAxis(AxisType.Y);
        yAxis.setLabel("Idade");
        yAxis.setMin(0);
        yAxis.setMax(this.chartIdadeMaxValue);
    }

    private BarChartModel initSalarioChart()
    {
        BarChartModel modelo = new BarChartModel();
        for (Pessoa pessoa : this.pessoaDao.getPessoas())
        {
            ChartSeries pessoaChart = new ChartSeries();
            pessoaChart.setLabel(pessoa.getIdPessoa().toString());
            pessoaChart.set("Salário", pessoa.getSalario());
            modelo.addSeries(pessoaChart);

            if (pessoa.getSalario() > this.chartSalarioMaxValue)
            {
                this.chartSalarioMaxValue = pessoa.getSalario();
            }
        }

        return modelo;
    }

    private void createSalarioChart()
    {
        this.chartSalario = this.initSalarioChart();

        this.chartSalario.setTitle("Salário");
        this.chartSalario.setLegendPosition("ne");
        this.chartSalario.setLegendPlacement(LegendPlacement.OUTSIDEGRID);

        Axis xAxis = this.chartSalario.getAxis(AxisType.X);
        xAxis.setLabel("Pessoa");

        Axis yAxis = this.chartSalario.getAxis(AxisType.Y);
        yAxis.setLabel("Salário");
        yAxis.setMin(0);
        yAxis.setMax(this.chartSalarioMaxValue);
    }
}
