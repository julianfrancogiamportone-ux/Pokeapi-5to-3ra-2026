const POKE_API = 'http://localhost:8080/api/characters';

const Peleador1Select = document.getElementById('Peleador1');
const Peleador2Select = document.getElementById('Peleador2');
const Peleador1Image = document.getElementById('Peleador1Image');
const Peleador2Image = document.getElementById('Peleador2Image');
const fightButton = document.getElementById('fightButton');
const resultDiv = document.getElementById('result');
//guardamos los datos obtenidos
let characters = [];

async function fetchData() {
//para una api
    try {
        const responseDB = await fetch(POKE_API);
        characters = await responseDB.json();}   
    catch (error) {
        console.error('Error al cargar los personajes:', error);}
loadPeleadores();
}

function loadPeleadores() {[...characters].forEach(Peleador => {
    const option1 = document.createElement('option');
    option1.value = JSON.stringify(Peleador);
    option1.text = `${Peleador.nombre} (${Peleador.armas[(Math.floor(Math.random() * 2) + 0)].nombre || Peleador.ataques[(Math.floor(Math.random() * 2) + 0)].nombre})`;
    Peleador1Select.appendChild(option1);
    const option2 = document.createElement('option');
    option2.value = JSON.stringify(Peleador);
    option2.text = `${Peleador.nombre} (${Peleador.armas[(Math.floor(Math.random() * 2) + 0)].nombre || Peleador.ataques[(Math.floor(Math.random() * 2) + 0)].nombre})`;
    Peleador2Select.appendChild(option2);
});

const selected = JSON.parse(Peleador1Select.value);
Peleador1Image.src = selected.imgurl;

const selected2 = JSON.parse(Peleador2Select.value);
Peleador2Image.src = selected2.imgurl;
}

Peleador1Select.addEventListener('change', () => {
    const selected = JSON.parse(Peleador1Select.value);
    Peleador1Image.src = selected.imgurl ;
});

Peleador2Select.addEventListener('change', () => {
    const selected = JSON.parse(Peleador2Select.value);
    Peleador2Image.src = selected.imgurl ;
});

function golpear(peleador1, peleador2) {
    dañot = peleador1.ataques[(Math.floor(Math.random() * 2) + 0)].danioBase + (peleador1.armas[0].bonificadordano);
    peleador2.puntosVida = peleador2.puntosVida - dañot;
    console.log(peleador1.nombre, "ha golpeado a ", peleador2.nombre,"y lo dejó a ", peleador2.puntosVida);
}

fightButton.addEventListener('click', () => {
    const fighter1 = JSON.parse(Peleador1Select.value);
    const fighter2 = JSON.parse(Peleador2Select.value);
    let winner;
    if (!fighter1 || !fighter2) {
        alert('Seleccioná ambos luchadores.');
        return;
    } else{
        while (fighter1.puntosVida > 0 && fighter2.puntosVida > 0) {
		golpear(fighter1, fighter2);
        if (fighter2.puntosVida > 0){
             golpear(fighter2, fighter1);
        }}
		if (fighter1.puntosVida > fighter2.puntosVida) {
		    winner = fighter1.nombre;
		} else if (fighter1.puntosVida === fighter2.puntosVida){
            winner = "¡Empate!";
		} else{
			winner = fighter2.nombre;
        }  
    }
    resultDiv.textContent = `🏆 El ganador es: ${winner}! 🥊`;
    resultDiv.classList.remove('hidden');
})
fetchData();
