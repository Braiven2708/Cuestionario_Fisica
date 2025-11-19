<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Evaluación de Física</title>
<style>
body {
    font-family: Arial, sans-serif;
    background: #f4f4f4;
    padding: 20px;
}
        .container {
    background: white;
    max-width: 800px;
    margin: auto;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
}
h1 {
    text-align: center;
}
        .question {
    margin-bottom: 20px;
}
button {
    padding: 10px 20px;
    background: #007bff;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}
        #resultado {
    margin-top: 20px;
    font-size: 18px;
    font-weight: bold;
}
    </style>
</head>
<body>
<div class="container">
<h1>Evaluación de Física</h1>
<p>Responde las 5 preguntas seleccionadas aleatoriamente.</p>
    <form id="quizForm"></form>
    <button onclick="calificar()">Enviar</button>
    <p id="resultado"></p>
</div>

<script>
const preguntas = [
        {
pregunta: "1. Un péndulo simple tiene una longitud de 1.2 m. ¿Cuál es su periodo aproximado? (g = 9.8 m/s²)",
opciones: ["1.5 s", "2.2 s", "3.1 s", "4.0 s"],
correcta: 0
        },
        {
pregunta: "2. Un objeto realiza un movimiento oscilatorio con frecuencia de 5 Hz. ¿Cuál es su periodo?",
opciones: ["0.20 s", "0.50 s", "2.0 s", "5.0 s"],
correcta: 0
        },
        {
pregunta: "3. Un péndulo tarda 0.8 s en ir de un extremo al otro. ¿Cuál es su periodo completo?",
opciones: ["0.8 s", "1.6 s", "3.2 s", "4.0 s"],
correcta: 1
        },
        {
pregunta: "4. Una onda transporta 40 J de energía en 5 segundos. ¿Cuál es su potencia?",
opciones: ["5 W", "8 W", "10 W", "12 W"],
correcta: 2
        },
        {
pregunta: "5. Una onda tiene una amplitud de 3 unidades. Si la intensidad es proporcional a A², ¿cuál es la intensidad relativa?",
opciones: ["3", "6", "9", "12"],
correcta: 2
        },
        {
pregunta: "6. Dos instrumentos tocan la misma nota (misma frecuencia), pero uno suena más " +
        "‘brillante’. ¿Qué propiedad permite distinguirlos?",
opciones: ["Amplitud", "Intensidad", "Timbre", "Periodo"],
correcta: 2
        },
        {
pregunta: "7. Un péndulo simple tiene un periodo de 2 s. Si se incrementa la longitud, ¿qué ocurre con el periodo?",
opciones: ["Disminuye", "Aumenta", "Permanece igual", "Se vuelve cero"],
correcta: 1
        },
        {
pregunta: "8. Una onda tiene una potencia de 15 W y atraviesa un área de 3 m². ¿Cuál es la intensidad?",
opciones: ["2.5 W/m²", "3 W/m²", "5 W/m²", "15 W/m²"],
correcta: 2
        },
        {
pregunta: "9. Una cuerda vibra con frecuencia de 10 Hz y longitud de onda de 0.5 m. ¿Cuál es la velocidad de la onda?",
opciones: ["2.5 m/s", "5 m/s", "10 m/s", "20 m/s"],
correcta: 1
        },
        {
pregunta: "10. Una onda incrementa su amplitud al doble. ¿Qué ocurre con su intensidad? (I ∝ A²)",
opciones: ["Se duplica", "Se triplica", "Se cuadruplica", "Se reduce a la mitad"],
correcta: 2
        },
        {
pregunta: "11. Un péndulo simple de 2 m oscila en un planeta con gravedad de 12 m/s². ¿Cuál es su periodo?",
opciones: ["1.29 s", "2.03 s", "2.85 s", "3.14 s"],
correcta: 0
        },
        {
pregunta: "12. Un movimiento oscilatorio tiene una amplitud de 0.10 m. ¿Cuál es su desplazamiento máximo?",
opciones: ["0.05 m", "0.10 m", "0.20 m", "0.30 m"],
correcta: 1
        },
        {
pregunta: "13. Una fuente sonora emite más armónicos que otra. ¿Qué propiedad cambia perceptiblemente?",
opciones: ["Tono", "Timbre", "Frecuencia", "Velocidad del sonido"],
correcta: 1
        },
        {
pregunta: "14. Una onda electromagnética tiene frecuencia de 3×10⁸ Hz y viaja a 3×10⁸ m/s. ¿Cuál es su longitud de onda?",
opciones: ["0.1 m", "1 m", "10 m", "100 m"],
correcta: 1
        },
        {
pregunta: "15. Un péndulo tiene longitud L y periodo T. Si la longitud aumenta 4 veces, ¿qué ocurre con el periodo?",
opciones: ["Se duplica", "Se triplica", "Se cuadruplica", "Permanece igual"],
correcta: 0
        }
        ];

function seleccionarPreguntas() {
    const seleccionadas = [];
    const usadas = new Set();

    while (seleccionadas.length < 5) {
        const index = Math.floor(Math.random() * preguntas.length);
        if (!usadas.has(index)) {
            usadas.add(index);
            seleccionadas.push(preguntas[index]);
        }
    }
    return seleccionadas;
}

const seleccion = seleccionarPreguntas();
const contenedor = document.getElementById("quizForm");

seleccion.forEach((p, i) => {
        const div = document.createElement("div");
div.className = "question";
div.innerHTML = `<p>${p.pregunta}</p>` + p.opciones
        .map((op, j) => `<label><input type="radio" name="p${i}" value="${j}"> ${op}</label><br>`)
        .join("");
    contenedor.appendChild(div);
});

function calificar() {
    let correctas = 0;

    seleccion.forEach((p, i) => {
        const respuesta = document.querySelector(`input[name='p${i}']:checked`);
    if (respuesta && parseInt(respuesta.value) === p.correcta) correctas++;
    });

    document.getElementById("resultado").innerText = `Obtuviste ${correctas} de 5 preguntas correctas.`;
}
</script>
</body>
</html>
