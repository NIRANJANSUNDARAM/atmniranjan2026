/* ===============================
   Animate On Scroll (AOS)
================================ */
if (typeof AOS !== 'undefined') {
    AOS.init({
        duration: 700,
        easing: 'ease-out-cubic',
        once: true,
        mirror: false,
        offset: 80
    });
}

/* ===============================
   Navbar Scroll Effect
================================ */
const navbar = document.querySelector('.navbar');

if (navbar) {
    window.addEventListener('scroll', () => {
        navbar.classList.toggle('scrolled', window.scrollY > 50);
    });
}

/* ===============================
   Typing Animation (Hero Section)
================================ */
const typedText = document.querySelector('.typed-text');
const cursor = document.querySelector('.cursor');

if (typedText && cursor) {
    const textArray = [
        'Professional Web Solutions',
        'Modern UI Development',
        'Scalable Applications',
        'Clean User Experiences'
    ];

    let textIndex = 0;
    let charIndex = 0;
    let isDeleting = false;

    const typingSpeed = 90;
    const deletingSpeed = 50;
    const delayBetweenTexts = 1800;

    function typeEffect() {
        const currentText = textArray[textIndex];
        cursor.classList.add('typing');

        if (!isDeleting) {
            typedText.textContent = currentText.slice(0, ++charIndex);
            if (charIndex === currentText.length) {
                cursor.classList.remove('typing');
                setTimeout(() => (isDeleting = true), delayBetweenTexts);
            }
        } else {
            typedText.textContent = currentText.slice(0, --charIndex);
            if (charIndex === 0) {
                isDeleting = false;
                textIndex = (textIndex + 1) % textArray.length;
            }
        }

        setTimeout(typeEffect, isDeleting ? deletingSpeed : typingSpeed);
    }

    setTimeout(typeEffect, 1000);
}

/* ===============================
   Stats Counter Animation
================================ */
const counters = document.querySelectorAll('.counter');

if (counters.length) {
    const counterObserver = new IntersectionObserver(
        entries => {
            entries.forEach(entry => {
                if (!entry.isIntersecting) return;

                const counter = entry.target;
                const target = +counter.dataset.target;
                const increment = Math.max(1, Math.floor(target / 200));
                let count = 0;

                const update = () => {
                    count += increment;
                    counter.textContent = count < target ? count : target;
                    if (count < target) requestAnimationFrame(update);
                };

                update();
                counterObserver.unobserve(counter);
            });
        },
        { threshold: 0.5 }
    );

    counters.forEach(counter => counterObserver.observe(counter));
}

/* ===============================
   Project Filtering
================================ */
const filterButtons = document.querySelectorAll('.filter-btn');
const projects = document.querySelectorAll('.project-item');

if (filterButtons.length && projects.length) {
    filterButtons.forEach(btn => {
        btn.addEventListener('click', () => {
            filterButtons.forEach(b => b.classList.remove('active'));
            btn.classList.add('active');

            const filter = btn.dataset.filter;

            projects.forEach(project => {
                const show =
                    filter === 'all' || project.dataset.category === filter;

                project.style.display = show ? 'block' : 'none';
                project.style.opacity = show ? '1' : '0';
                project.style.transform = show ? 'scale(1)' : 'scale(0.95)';
            });
        });
    });
}

/* ===============================
   Contact Form Validation
================================ */
const contactForm = document.getElementById('contactForm');

if (contactForm) {
    contactForm.addEventListener('submit', e => {
        e.preventDefault();

        let valid = true;
        const fields = contactForm.querySelectorAll('[required]');

        fields.forEach(field => {
            const isEmpty = !field.value.trim();
            field.classList.toggle('is-invalid', isEmpty);
            valid = valid && !isEmpty;
        });

        if (valid) {
            alert('Thank you for reaching out. I’ll respond shortly.');
            contactForm.reset();
        } else {
            alert('Please complete all required fields.');
        }
    });
}

/* ===============================
   Smooth Scrolling
================================ */
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', e => {
        const target = document.querySelector(anchor.getAttribute('href'));
        if (!target) return;

        e.preventDefault();
        target.scrollIntoView({
            behavior: 'smooth',
            block: 'start'
        });
    });
});

/* ===============================
   Active Navigation Highlight
================================ */
const navLinks = document.querySelectorAll('.nav-link');
const currentPath = window.location.pathname;

navLinks.forEach(link => {
    const href = link.getAttribute('href');
    if (
        (href === 'index.html' && currentPath.endsWith('/')) ||
        currentPath.includes(href)
    ) {
        link.classList.add('active');
    }
});

/* ===============================
   Subtle Hero Parallax
================================ */
const hero = document.querySelector('.hero-section');

if (hero) {
    window.addEventListener('scroll', () => {
        hero.style.transform = `translateY(${window.scrollY * 0.15}px)`;
    });
}

/* ===============================
   Bootstrap Tooltips
================================ */
if (typeof bootstrap !== 'undefined') {
    document
        .querySelectorAll('[data-bs-toggle="tooltip"]')
        .forEach(el => new bootstrap.Tooltip(el));
}