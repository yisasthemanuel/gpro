package org.jlobato.gpro.forecast;

import org.jlobato.gpro.setup.CalculadorSetupCambioClimaFactory;
import org.jlobato.gpro.setup.CalculadorSetupCambioClimaStrategy;
import org.jlobato.gpro.setup.CalculadorSetupCambioTemperaturaFactory;
import org.jlobato.gpro.setup.CalculadorSetupCambioTemperaturaStrategy;
import org.jlobato.gpro.setup.CarSetup;
import org.jlobato.gpro.setup.PracticeSession;

/**
 * 
 * @author jlobato
 *
 */
public class CarSetupUpdater {

	/**
	 * 
	 * @param theSession
	 * @param setup
	 * @param raceForecast
	 */
	public void updateSetup(PracticeSession theSession, CarSetup setup, IRaceForecast raceForecast) {
		//1. Obtener el modelo de clima. Hay que tirar de la vista de weather y acceder al método getModel()
		//2. Si hay modelo disponible partir de la Q1
		//3. Calcular la Q2 en base a los cambios
		//4. Calcular la Race en base a los datos de los 4 intervalos. Hay que implementar un calculador de temperatura media de carrera estimado
		//5. Implementar la vista para representar los resultados. En principio serán simples System.out, luego será una vista Swing
		
		//Setup
		if (setup != null) {
			//Pronóstico de clima para la carrera
			//Setup resultante para la Q2
			CarSetup q2Setup = null;
			//Setup resultante para la Carrera
			CarSetup raceSetup = null;
			
			//Creamos el calculador para el cambio de temperatura
			CalculadorSetupCambioTemperaturaStrategy calculadorTempChangedSetup = CalculadorSetupCambioTemperaturaFactory.getInstance().create(CalculadorSetupCambioTemperaturaFactory.RL_TEMPERATURE_STRATEGY);
			//Creamos el calculador para el cambio de clima
			CalculadorSetupCambioClimaStrategy calculadorWeatherChangedSetup = CalculadorSetupCambioClimaFactory.getInstance().create(CalculadorSetupCambioClimaFactory.CV_PN_WEATHER_STRATEGY);
			
			//El perfect setup siempre va en relación a la Q1. Hacemos el cambio para la Q2
			if (raceForecast.getQ1Forecast() != null && raceForecast.getQ2Forecast() != null) {
				try {
					//Aplicamos los cambios de temperatura
					CarSetup q2TransientSetup = calculadorTempChangedSetup.getChangedSetup(setup, raceForecast.getQ1Forecast().getTemperature(), raceForecast.getQ2Forecast().getTemperature());
					//Aplicamos los cambios de clima
					q2Setup = calculadorWeatherChangedSetup.getWeatherChangedSetup(q2TransientSetup, raceForecast.getQ1Forecast().getWeather(), raceForecast.getQ2Forecast().getWeather(), raceForecast.getQ2Forecast().getTemperature());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			//El perfect setup siempre va en relación a la Q1. Hacemos el cambio para la carrera
			if (raceForecast.getQ1Forecast() != null && raceForecast.getQ2Forecast() != null && raceForecast.getRaceForecast() != null) {
				try {
					//Aplicamos los cambios de temperatura
					CarSetup raceTransientSetup = calculadorTempChangedSetup.getChangedSetup(setup, raceForecast.getQ1Forecast().getTemperature(), raceForecast.getEstimatedRaceTemperature());
					//Aplicamos los cambios de clima. Ojo, ponemos el mismo weather que la Q2 porque la carrera comienza con el mismo clima que la Q2
					//Esto se puede variar si sabemos que el clima va a cambiar durante el resto de la carrera
					raceSetup = calculadorWeatherChangedSetup.getWeatherChangedSetup(raceTransientSetup, raceForecast.getQ1Forecast().getWeather(), raceForecast.getQ2Forecast().getWeather(), raceForecast.getEstimatedRaceTemperature());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			//Ahora estos setups deberían actualizar el modelo de la practice session y éstos a su vez lanzar un evento que refresque la vista del practice session
			if (q2Setup != null) {
				theSession.setQ2Setup(q2Setup);
			}
			
			if (raceSetup != null) {
				theSession.setRaceSetup(raceSetup);
			}
		}
		
	}

}
