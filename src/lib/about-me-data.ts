import { GitHubIcon, LinkedInIcon, XIcon } from '@/components/SocialIcons'

export const aboutMeData = {
  name: 'Adrian Witaszak',
  email: 'adrianwitaszak@gmail.com',
  portraitImage: '/images/portrait.jpg',
  metaDescription:
    'I’m Adrian Witaszak. I live in York, UK, where I lead innovative software solutions at CharLEE X and pursue my passion for karting.',
  description: `I’m Adrian, a software engineer and entrepreneur based in York, UK. I’m the founder of CharLEE X, where we create cutting-edge software solutions for eCommerce and bespoke projects.`,
  socialLinks: [
    {
      name: 'LinkedIn',
      href: 'https://www.linkedin.com/in/adrian-witaszak/',
      icon: LinkedInIcon,
      aria: 'Follow on LinkedIn',
    },
    {
      name: 'Twitter',
      href: 'https://x.com/adrianwita',
      icon: XIcon,
      aria: 'Follow on Twitter',
    },
    {
      name: 'GitHub',
      href: 'https://github.com/charlee-dev',
      icon: GitHubIcon,
      aria: 'Follow on GitHub',
    },
  ],
}
