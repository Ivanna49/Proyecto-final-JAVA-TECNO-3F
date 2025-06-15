# Proyecto Policía - Gestión de Armas y Escuadrones

Este proyecto en Java modela una gestión básica de policías, armas (cortas y largas) y escuadrones. Permite crear objetos con sus atributos, asociar policías con armas y organizar escuadrones con sus integrantes y equipamiento.

## Contenido

- Clases para modelar armas cortas y largas, con atributos como marca, calibre, estado, nivel, etc.
- Clase Policía que asocia un policía con un arma asignada.
- Clase Escuadrón que agrupa policías y armas, con métodos para contar integrantes y armas en condiciones.
- Uso de enumeraciones para estados de armas (nueva, en uso, mantenimiento, fuera de servicio).
- Implementación de comparación entre armas largas según su nivel.

## Cómo usar

1. Clonar o descargar el repositorio.
2. Importar el proyecto en tu IDE Java preferido (Eclipse, IntelliJ, NetBeans, etc).
3. Ejecutar la clase `Main` para ver el ejemplo de creación de policías, armas y escuadrones.
4. Modificar o extender las clases para adaptarlo a tus necesidades.

## Tecnologías

- Java 8 o superior
- IDE recomendado: cualquier entorno compatible con Java

## Estructura de Clases

- `Arma` (abstracta): clase base para armas.
- `ArmaCorta`: extiende Arma, con atributo `esAutomatica`.
- `ArmaLarga`: extiende Arma, con atributos `selloRENAR`, `descripcionUso` y `nivel`.
- `Policia`: contiene datos del policía y arma asignada.
- `Escuadron`: grupo de policías y armas con métodos para estadísticas.
- `EstadoArma` (enum): estados posibles de un arma.

## Ejemplo de salida

