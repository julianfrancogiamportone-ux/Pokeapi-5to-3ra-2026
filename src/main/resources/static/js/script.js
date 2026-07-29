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
Peleador1Image.src = selected.url_imagen || 'placeholder1.png';

const selected2 = JSON.parse(Peleador2Select.value);
Peleador2Image.src = selected2.url_imagen || 'placeholder2.png';
}

Peleador1Select.addEventListener('change', () => {
    const selected = JSON.parse(Peleador1Select.value);
    Peleador1Image.src = selected.url_imagen || 'placeholder1.png';
});

Peleador2Select.addEventListener('change', () => {
    const selected = JSON.parse(Peleador2Select.value);
    Peleador2Image.src = selected.url_imagen || 'placeholder2.png';
});

fightButton.addEventListener('click', () => {
    const fighter1 = JSON.parse(Peleador1Select.value);
    const fighter2 = JSON.parse(Peleador2Select.value);
    if (!fighter1 || !fighter2) {
        alert('Seleccioná ambos luchadores.');
    return;
}

const power1 = fighter1.puntosVida || (Math.floor(Math.random() * 1000) + 500);
const power2 = fighter2.puntosVida|| (Math.floor(Math.random() * 1000) + 500);
let winner;
if (power1 > power2) {
    winner = fighter1.nombre;
} else if (power2 > power1) {
    winner = fighter2.nombre;
} else {
    winner = "¡Empate!";
}
resultDiv.textContent = `🏆 El ganador es: ${winner}! 🥊`;
resultDiv.classList.remove('hidden');
});
fetchData();
